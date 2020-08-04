package com.yanbingxu.sp09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Yuanzhibx
 * @Date 2020-08-04
 */
@EnableFeignClients
@SpringBootApplication
public class Sp09FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp09FeignApplication.class, args);
    }

}
