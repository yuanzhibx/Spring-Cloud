package com.yanbingxu.m4;

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
    AmqpTemplate t;

    public void send() {
        while (true) {
            System.out.println("输入消息:  ");
            String s = new Scanner(System.in).nextLine();
            System.out.println("输入路由键:  ");
            String keys = new Scanner(System.in).nextLine();
            t.convertAndSend("direct_logs", keys, s);
        }
    }

}
