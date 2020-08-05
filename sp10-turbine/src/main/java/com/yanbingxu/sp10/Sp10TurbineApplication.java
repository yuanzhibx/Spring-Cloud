package com.yanbingxu.sp10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author yanbingxu
 * @Date 2020-08-05
 */
@EnableTurbine
@SpringBootApplication
public class Sp10TurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp10TurbineApplication.class, args);
    }

}
