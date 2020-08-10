package com.yanbingxu.m2;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yuanzhibx
 * @Date 2020-08-10
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        for (int i = 0; i < 10; i++) {
            String msg = "消息 " + i;
            if (i >= 8) {
                msg += "..................";
            }
            amqpTemplate.convertAndSend("task_queue", msg);
        }
    }

}
