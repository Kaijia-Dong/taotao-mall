package com.taotao.service.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-09 15:42
 **/
@Slf4j
@Component
@RabbitListener(queues = "QUEUE_A")
public class StringConsumer {

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void process(String msg) {
        log.info("[string] process message:" + msg);
    }

}
