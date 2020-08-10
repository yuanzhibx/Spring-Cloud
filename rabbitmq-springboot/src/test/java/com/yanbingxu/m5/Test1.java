package com.yanbingxu.m5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    }

}
