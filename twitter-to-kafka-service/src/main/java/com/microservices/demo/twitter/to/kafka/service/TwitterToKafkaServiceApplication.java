package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.twitter.to.kafka.service.config.TwetterToKafkaServiceConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

    public static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);
    public final TwetterToKafkaServiceConfigData configData;

    public TwitterToKafkaServiceApplication(TwetterToKafkaServiceConfigData configData){
        this.configData = configData;
    }
    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        LOG.info("App start ...");
        LOG.info(Arrays.toString(configData.getTwitterKeywords().toArray(new String[]{})));
        LOG.info(configData.getWelcomeMessage());
    }
}
