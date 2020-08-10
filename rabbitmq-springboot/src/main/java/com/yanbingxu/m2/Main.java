package com.yanbingxu.m2;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author yanbingxu
 * @Date 2020-08-10
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Queue helloworldQueue() {
        // 持久, 非排他, 非自动删除
        return new Queue("task_queue", true);
    }

}
