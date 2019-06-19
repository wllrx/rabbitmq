package com.zoe.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : DemoController
 * @Author : zoe
 * @Date : 2019/6/19 10:01
 */
@RestController
public class DemoController {

    @Resource
    private DemoProducer demoProducer;

    @PostMapping("demoMessage")
    public void demoMessage(){
        for (int i=0;i<10;i++){
            demoProducer.send();
        }
    }
}
