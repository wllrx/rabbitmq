package com.zoe.simple;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName : Producer
 * @Author : zoe
 * @Date : 2019/6/17 15:51
 */
@Component
public class Producer {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String message = "hello";
        this.rabbitTemplate.convertAndSend("simple",message);
    }
}
