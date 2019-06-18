package com.zoe.fanout;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : FanoutController
 * @Author : zoe
 * @Date : 2019/6/18 9:54
 */
@RestController
public class FanoutController {

    @Resource
    private FanoutProducer fanoutProducer;

    @PostMapping("/message-fanout")
    public void sendFanout(){
        this.fanoutProducer.send();
    }
}
