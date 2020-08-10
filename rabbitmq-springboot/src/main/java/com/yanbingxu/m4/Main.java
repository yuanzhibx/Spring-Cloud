package com.yanbingxu.m4;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 路由模式
 *
 * @author yanbingxu
 * @Date 2020-08-10
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public DirectExchange directExchange() {
        // 非持久, 非自动删除
        return new DirectExchange("direct_logs", false, false);
    }

}
