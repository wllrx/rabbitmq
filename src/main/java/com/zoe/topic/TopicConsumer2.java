package com.zoe.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : TopicConsumer2
 * @Author : zoe
 * @Date : 2019/6/17 16:56
 */
@Slf4j
@Component
public class TopicConsumer2 {

    @RabbitListener(queues = "topic.message2")
    public void receive(String message) {
        log.info("消费者2收到消息：{}", message);
    }
}
