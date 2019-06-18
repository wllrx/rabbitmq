package com.zoe.confirm;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : ConfirmConfiguration
 * @Author : zoe
 * @Date : 2019/6/18 11:37
 */
@Configuration
public class ConfirmConfiguration {

    /**
     * 声明confirm.message队列
     */
    @Bean
    public Queue confirmQueue() {
        return new Queue("confirm.message");
    }

    /**
     * 声明一个名为exchange-2的交换机
     */
    @Bean
    public TopicExchange exchange2() {
        return new TopicExchange("exchange-2");
    }

    /**
     * 将confirm.message的队列绑定到exchange-2交换机
     */
    @Bean
    public Binding bindMessage1() {
        return BindingBuilder.bind(confirmQueue()).to(exchange2()).with("confirm.message");
    }
}
