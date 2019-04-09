package com.taotao.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-09 13:44
 **/
@Configuration
public class RabbitConfig {

    public static final String QUEUE_A = "QUEUE_A";

    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A); //队列持久
    }
}
