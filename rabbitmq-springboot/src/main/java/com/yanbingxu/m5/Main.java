package com.yanbingxu.m5;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 主题模式
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
    public TopicExchange directExchange() {
        // 非持久, 非自动删除
        return new TopicExchange("topic_logs", false, false);
    }

}
