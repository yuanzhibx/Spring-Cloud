package com.yanbingxu.m3;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Yuanzhibx
 * @Date 2020-08-10
 */
@Component
public class Consumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue, exchange = @Exchange(name = "logs", declare = "false")))
    public void receive1(String s) {
        System.out.println("Consumer.receive1  --  收到:  " + s);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue, exchange = @Exchange(name = "logs", declare = "false")))
    public void receive2(String s) {
        System.out.println("Consumer.receive2  --  收到:  " + s);
    }

}
