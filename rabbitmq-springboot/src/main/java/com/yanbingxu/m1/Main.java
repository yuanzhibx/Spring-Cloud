package com.yanbingxu.m1;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 简单模式
 *
 * @author yanbingxu
 * @Date 2020-08-08
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Queue helloworldQueue() {
        //retrun new Queue("helloworld") - 持久, 非排他, 非自动删除
        // 非持久
        return new Queue("helloworld", false);
    }

}
