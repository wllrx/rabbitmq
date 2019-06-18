package com.zoe.confirm;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName : ConfirmConsumer
 * @Author : zoe
 * @Date : 2019/6/18 12:57
 */
@Component
@Slf4j
public class ConfirmConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "confirm.message",durable = "true")
            ,exchange = @Exchange(value = "exchange-2",type = "topic")
            ,key = "confirm.message"))
    public void receive(String message, Message message1, Channel channel) throws IOException {
        log.info("消费者收到消息：{}", message);
        long deliverTag = message1.getMessageProperties().getDeliveryTag();
        //第一个deliveryTag参数为每条信息带有的tag值，第二个multiple参数为布尔类型
        //为true时会将小于等于此次tag的所有消息都确认掉，如果为false则只确认当前tag的信息，可根据实际情况进行选择。
        channel.basicAck(deliverTag, false);
    }
}
