package com.yanbingxu.sp02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Sp02ItemserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp02ItemserviceApplication.class, args);
    }

}
