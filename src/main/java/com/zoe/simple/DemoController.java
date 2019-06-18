package com.zoe.simple;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : DemoController
 * @Author : zoe
 * @Date : 2019/6/17 15:55
 */
@RestController
public class DemoController {

    @Resource
    private Producer producer;

    @PostMapping("/message")
    public void send(){
        for (int i = 0;i<10;i++){
            this.producer.send();
        }
    }
}
