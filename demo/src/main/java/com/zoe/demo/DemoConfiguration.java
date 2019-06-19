package com.zoe.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : DemoConfiguration
 * @Author : zoe
 * @Date : 2019/6/19 9:07
 */
@Configuration
public class DemoConfiguration {

    /**
     * 声明一个名为demo的队列
     * @return .
     */
    @Bean
    public Queue demoQueue(){
        return new Queue("demo");
    }
}
