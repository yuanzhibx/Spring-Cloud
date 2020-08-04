package com.yanbingxu.sp08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Yuanzhibx
 * @Date 2020-08-3
 */
@EnableHystrixDashboard
@SpringBootApplication
public class Sp08HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp08HystrixDashboardApplication.class, args);
    }

}
