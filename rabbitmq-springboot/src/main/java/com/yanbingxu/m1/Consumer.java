package com.yanbingxu.m1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Yuanzhibx
 * @Date 2020-08-08
 */
@Component
@RabbitListener(queues = "helloworld")
public class Consumer {

    /**
     * 指定处理消息的方法
     */
    @RabbitHandler
    public void receive(String msg) {
        System.out.println("收到:  " + msg);
    }

}
