package com.zoe.confirm;

import cn.gjing.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @ClassName : ConfirmProducer
 * @Author : zoe
 * @Date : 2019/6/18 11:45
 */
@Component
@Slf4j
public class ConfirmProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 如果消息没有到exchange,则confirm回调,ack=false
     * 如果消息到达exchange,则confirm回调,ack=true
     * exchange到queue成功,则不回调return
     * exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
     */
    private final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
        if (!ack) {
            log.error("消息发送失败：correlationData: {},cause: {}", correlationData, cause);
        }else {
            log.info("消息发送成功：correlationData: {},ack: {}", correlationData, ack);
        }
    };

    private final RabbitTemplate.ReturnCallback returnCallback = (message, replyCode, replyText, exchange, routeKey) ->
            log.error("消息丢失: exchange: {},routeKey: {},replyCode: {},replyText: {}", exchange, routeKey, replyCode, replyText);

    /**
     * 发送消息
     * @param message 消息内容
     */
    public void send(String message) {
        // 构建回调返回的数据
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(TimeUtil.localDateTimeToStamp(LocalDateTime.now()) + "");

        Message message1 = MessageBuilder.withBody(message.toString().getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                // 将CorrelationData的id 与 Message的correlationId绑定，然后关系保存起来,然后人工处理
                .setCorrelationId(correlationData.getId())
                .build();
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend("exchange-2", "confirm.message", message1, correlationData);
    }
}
