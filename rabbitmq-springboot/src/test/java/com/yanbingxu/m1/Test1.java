package com.yanbingxu.m1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * @author Yuanzhibx
 * @Date 2020-08-08
 */
@SpringBootTest
public class Test1 {

    @Autowired
    private Producer p;

    @Test
    void test1() {
        p.send();
        System.out.println("----按回车结束----");
    }

}
