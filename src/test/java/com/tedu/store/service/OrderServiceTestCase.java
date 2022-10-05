package com.tedu.store.service;

import com.tedu.store.entity.Address;
import com.tedu.store.entity.Order;
import com.tedu.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderServiceTestCase {

    @Autowired
    private IOrderService orderService;


    @Test
    public void createOrder() {

        Integer[] cartIds = {
                3,5
        };
        Order order = orderService.createOrder(12, "test", 21, cartIds);
        System.err.println("order = " + order);
    }
}
