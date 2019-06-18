package com.zoe.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @ClassName : RabbitMqConfiguration
 * @Author : zoe
 * @Date : 2019/6/17 15:38
 */

@Configuration
public class RabbitMqConfiguration {

    /**
     * 声明一个名为simple的队列
     */
    @Bean
    public Queue testQueue(){
        return new Queue("simple");
    }

    /**
     * 声明一个名为topic.message1的队列
     * @return .
     */
    @Bean
    public Queue topicQueue(){
        return new Queue("topic.message1");
    }

    /**
     * 声明一个名为topic.message2的队列
     * @return .
     */
    @Bean
    public Queue topicQueue2(){
        return new Queue("topic.message2");
    }

    /**
     * 声明一个名为exchange的交换机
     * @return .
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    /**
     *  将topic.message1 绑定到exchange交换机
     * @return
     */
    @Bean
    public Binding bindMessage1(){
        return BindingBuilder.bind(topicQueue()).to(exchange()).with("topic.message1");
    }

    /**
     *  将topic.message2 绑定到exchange交换机
     * @return
     */
    @Bean
    public Binding bindMessage2(){
        return BindingBuilder.bind(topicQueue()).to(exchange()).with("topic.message2");
    }

    /**
     * 声明一个名为fanout.1的队列
     * @return .
     */
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanout.1");
    }

    /**
     * 声明一个名为fanout.2的队列
     * @return .
     */
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanout.2");
    }

    /**
     * 声明一个名为fanout.3的队列
     * @return .
     */
    @Bean
    public Queue fanoutQueue3(){
        return new Queue("fanout.3");
    }

    /**
     * 声明一个名为fanoutExchange的转发器
     * @return .
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将队列fanoutQueue1绑定到fanout转发器
     * @return .
     */
    @Bean
    public Binding bindFanout1(){
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    /**
     * 将队列fanoutQueue2绑定到fanout转发器
     * @return .
     */
    @Bean
    public Binding bindFanout2(){
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    /**
     * 将队列fanoutQueue3绑定到fanout转发器
     * @return .
     */
    @Bean
    public Binding bindFanout3(){
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }
}
