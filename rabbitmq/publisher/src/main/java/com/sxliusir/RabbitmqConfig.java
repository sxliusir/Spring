package com.sxliusir;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    @Bean
    protected Queue queue(){
        Queue queue = new Queue("myqueue");
        return queue;
    }
}