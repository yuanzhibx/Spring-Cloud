package com.yanbingxu.m1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yuanzhibx
 * @Date 2020-08-08
 */
@Component
public class Producer {

    @Autowired
    AmqpTemplate t;

    public void send() {
        // 向 helloworld 队列发送消息
        t.convertAndSend("helloworld", "Hello world!! " + System.currentTimeMillis());
        System.out.println("消息已发送");
    }

}
