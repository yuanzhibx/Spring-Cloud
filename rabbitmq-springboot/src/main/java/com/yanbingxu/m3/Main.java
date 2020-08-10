package com.yanbingxu.m3;

import org.springframework.amqp.core.FanoutExchange;
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
    public FanoutExchange fanoutExchange() {
        // 非持久, 非自动删除
        return new FanoutExchange("logs", false, false);
    }

}
