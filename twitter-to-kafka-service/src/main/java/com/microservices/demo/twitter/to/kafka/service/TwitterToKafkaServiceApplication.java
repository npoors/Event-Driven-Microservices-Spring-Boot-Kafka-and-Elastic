package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.twitter.to.kafka.service.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = "com.microservices.demo")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

    public static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);
    public final TwitterToKafkaServiceConfigData configData;
    public final StreamRunner streamRunner;
    public TwitterToKafkaServiceApplication(TwitterToKafkaServiceConfigData configData, StreamRunner streamRunner){
        this.configData = configData;
        this.streamRunner = streamRunner;
    }
    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        LOG.info("App start ...");
        LOG.info(Arrays.toString(configData.getTwitterKeywords().toArray(new String[]{})));
        LOG.info(configData.getWelcomeMessage());
        streamRunner.start();
    }
}
