package com.zoe.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : TopicConsumer1
 * @Author : zoe
 * @Date : 2019/6/17 16:56
 */
@Component
@Slf4j
public class TopicConsumer1 {
    @RabbitListener(queues = "topic.message1")
    public void receive(String message) {
        log.info("消费者1收到消息：{}", message);
    }
}
