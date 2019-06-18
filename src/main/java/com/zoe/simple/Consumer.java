package com.zoe.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : Consumer
 * @Author : zoe
 * @Date : 2019/6/17 15:53
 */
@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "simple")
    public void receive(String message){
        log.info("消费者收到消息:{}",message);
    }
}
