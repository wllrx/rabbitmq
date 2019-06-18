package com.zoe.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName : TopicProducer
 * @Author : zoe
 * @Date : 2019/6/17 16:45
 */
@Component
public class TopicProducer {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String message1 = "I am topic.message1";
        String message2 = "I am topic.message2";
        this.rabbitTemplate.convertAndSend("exchange", "topic.message1", message1);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message2", message2);
    }
}
