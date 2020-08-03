package com.yanbingxu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yuanzhibx
 * @Date 2020-07-31
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class Sp06RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp06RibbonApplication.class, args);
    }

    /**
     * 创建 RestTemplate 实例, 并存入 Spring 容器
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
        // 建立连接等待超时时间
        f.setConnectTimeout(1000);
        // 连接已建立并发送请求, 等待接收响应的超时时间
        f.setReadTimeout(1000);
        return new RestTemplate(f);
    }

}
