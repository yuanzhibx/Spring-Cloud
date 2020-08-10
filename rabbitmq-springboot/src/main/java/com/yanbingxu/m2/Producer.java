package com.yanbingxu.m2;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author Yuanzhibx
 * @Date 2020-08-10
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate t;

    public void send() {
        while (true) {
            System.out.print("输入:");
            String s = new Scanner(System.in).nextLine();

            //spring 默认将消息的 DeliveryMode 设置为 PERSISTENT 持久化,
            t.convertAndSend("task_queue", s);
        }
    }

}
