package com.yanbingxu.sp03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Yuanzhibx
 * @Date 2020-07-28
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Sp03UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp03UserserviceApplication.class, args);
    }

}
