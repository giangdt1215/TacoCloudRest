package com.dtg.tacocloud.config;

import org.apache.activemq.artemis.jms.client.ActiveMQDestination;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

import javax.jms.Destination;

@Configuration
public class MessagingConfig {

    @Bean
    public Destination orderQueue(){
        return new ActiveMQQueue("tacocloud.order.queue");
    }
}
