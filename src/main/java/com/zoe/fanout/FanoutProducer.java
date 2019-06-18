package com.zoe.fanout;

import javafx.print.PrinterAttributes;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName : FanoutProducer
 * @Author : zoe
 * @Date : 2019/6/18 9:45
 */
@Component
public class FanoutProducer {
    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "hello,i am speaker";
        this.amqpTemplate.convertAndSend("fanoutExchange","",message);
    }
}
