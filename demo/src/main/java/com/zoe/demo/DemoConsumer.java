package com.zoe.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : DemoConsumer
 * @Author : zoe
 * @Date : 2019/6/19 9:20
 */
@Component
@Slf4j
public class DemoConsumer {

    @RabbitListener(queues = "demo")
    public void receive(String message){
        log.info("消费者收到消息: "+message);
    }

}
