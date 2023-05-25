package com.microservices.demo.twitter.to.kafka.service.runner.impl;

import com.microservices.demo.twitter.to.kafka.service.listener.TwitterKafkaStatusListener;
import com.microservices.demo.twitter.to.kafka.service.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PreDestroy;
import java.util.Arrays;

@Component
public class TwitterKafkaStreamRunnerImpl implements StreamRunner {

    private final TwitterKafkaStatusListener twitterKafkaStatusListener;
    private final TwitterToKafkaServiceConfigData twetterToKafkaServiceConfigData;
    private TwitterStream twitterStream;
    public static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStreamRunnerImpl.class);

    public TwitterKafkaStreamRunnerImpl(TwitterKafkaStatusListener statusListener, TwitterToKafkaServiceConfigData configData){
        this.twitterKafkaStatusListener = statusListener;
        this.twetterToKafkaServiceConfigData = configData;
    }

    @Override
    public void start() throws TwitterException {
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterKafkaStatusListener);
        addFilter();
    }

    @PreDestroy
    public void shutdown(){
        if (twitterStream != null){
            LOG.info("Closing twitter stream!");
            twitterStream.shutdown();
        }
    }
    private void addFilter() {
        String[] keywords = twetterToKafkaServiceConfigData.getTwitterKeywords().toArray(new String[0]);
        FilterQuery filterQuery = new FilterQuery(keywords);
        twitterStream.filter(filterQuery);
        LOG.info("Started filtering twitter stream for kewords {}", Arrays.toString(keywords));
    }
}
