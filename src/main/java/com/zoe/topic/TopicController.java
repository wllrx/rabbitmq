package com.zoe.topic;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : TopicController
 * @Author : zoe
 * @Date : 2019/6/17 16:57
 */
@RestController
public class TopicController {

    @Resource
    private TopicProducer topicProducer;

    @PostMapping("/message-topic")
    public void sendMessageTopic() {
        for (int i = 0; i < 10; i++) {
            this.topicProducer.send();
        }
    }
}
