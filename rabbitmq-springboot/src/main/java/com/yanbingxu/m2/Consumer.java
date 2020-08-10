package com.yanbingxu.m2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Yuanzhibx
 * @Date 2020-08-10
 */
@Component
public class Consumer {

    @RabbitListener(queues = "task_queue")
    public void receive1(String msg) throws InterruptedException {
        System.out.println("消费者1 - 收到： " + msg);
        for (int i = 0; i < msg.length(); i++) {
            if ('.' == msg.charAt(i)) {
                Thread.sleep(1000);
            }
        }
        System.out.println("消费者1 - 消息处理完成");
    }

    @RabbitListener(queues = "task_queue")
    public void receive2(String msg) throws InterruptedException {
        System.out.println("消费者2 - 收到： " + msg);
        for (int i = 0; i < msg.length(); i++) {
            if ('.' == msg.charAt(i)) {
                Thread.sleep(1000);
            }
        }
        System.out.println("消费者2 - 消息处理完成");
    }

}
