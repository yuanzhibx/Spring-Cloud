package com.yanbingxu.m3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * @author Yuanzhibx
 * @Date 2020-08-10
 */
@SpringBootTest
public class Test1 {

    @Autowired
    private Producer p;

    @Test
    public void test1() {
        p.send();
        new Scanner(System.in).nextLine();
    }

}
