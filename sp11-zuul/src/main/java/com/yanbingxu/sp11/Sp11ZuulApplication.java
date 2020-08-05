package com.yanbingxu.sp11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author yanbingxu
 * @Date 2020-08-05
 */
@EnableZuulProxy
@SpringBootApplication
public class Sp11ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp11ZuulApplication.class, args);
    }

}
