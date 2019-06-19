package com.zoe.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName : DemoProducer
 * @Author : zoe
 * @Date : 2019/6/19 9:10
 */
@Component
public class DemoProducer {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "1111111111111111111";
        amqpTemplate.convertAndSend("demo",message);
    }
}
