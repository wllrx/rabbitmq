package com.zoe.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : FanoutConsumer1
 * @Author : zoe
 * @Date : 2019/6/18 9:49
 */
@Component
@Slf4j
public class FanoutConsumer3 {
    
    @RabbitListener(queues =  "fanout.3")
    public void receive(String message){
        log.info("消费者3收到消息:{}",message);
    }
}
