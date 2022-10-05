package com.tedu.store.mapper;


import com.tedu.store.entity.Cart;
import com.tedu.store.entity.Order;
import com.tedu.store.entity.OrderItem;
import com.tedu.store.vo.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class OrderMapperTestCase {

    @Autowired
    OrderMapper orderMapper;


    @Test
    public void insertOrder() {
       Order order = new Order();
       order.setUid(1);
       order.setRecvPhone("123123123");
       order.setRecvName("张三");
        Integer integer = orderMapper.insertOrder(order);
        System.out.println("integer = " + integer);
    }
    @Test
    public void insertOrderItem() {
        OrderItem order = new OrderItem();
        order.setOid(1);
        order.setGoodsCount(12);
        Integer integer = orderMapper.insertOrderItem(order);
        System.out.println("integer = " + integer);
    }


}
