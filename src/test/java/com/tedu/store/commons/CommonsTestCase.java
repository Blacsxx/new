package com.tedu.store.commons;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class CommonsTestCase {

    @Test
    public void uuid(){
        for (int i = 0; i < 5; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
