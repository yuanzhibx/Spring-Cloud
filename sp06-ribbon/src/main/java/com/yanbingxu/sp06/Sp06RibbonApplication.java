package com.yanbingxu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yuanzhibx
 * @Date 2020-07-31
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Sp06RibbonApplication {

    /**
     * 创建 RestTemplate 实例, 并存入 Spring 容器
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Sp06RibbonApplication.class, args);
    }

}
