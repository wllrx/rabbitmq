package com.zoe.confirm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : ConfirmController
 * @Author : zoe
 * @Date : 2019/6/18 12:58
 */
@RestController
public class ConfirmController {

    @Resource
    private ConfirmProducer confirmProducer;

    @PostMapping("/confirm-message")
    public void confirmMessage() {
        confirmProducer.send("hello confirm message");
    }
}
