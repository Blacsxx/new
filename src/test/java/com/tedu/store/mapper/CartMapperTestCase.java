package com.tedu.store.mapper;


import com.tedu.store.entity.Cart;
import com.tedu.store.entity.District;
import com.tedu.store.vo.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CartMapperTestCase {

    @Autowired
    CartMapper cartMapper;


    @Test
    public void addNew() {
        Cart cart = new Cart();
        cart.setGid(2);
        cart.setUid(3);
        cart.setCount(3);
        cart.setPrice(66666L);
        cart.setCreatedUser("admin");
        cart.setModifiedUser("admin");
        cart.setCreatedTime(new Date());
        cart.setModifiedTime(new Date());
        Integer integer = cartMapper.addNew(cart);
        System.err.println("integer = " + integer);
    }

    @Test
    public void updateCount() {
        Integer integer = cartMapper.updateCount(1, 55);
        System.err.println("integer = " + integer);
    }

    @Test
    public void findByUidAndGid() {
        Cart cart = cartMapper.findByUidAndGid(3, 2);
        System.err.println("cart = " + cart);
    }

    @Test
    public void findByUid() {
        List<CartVO> list = cartMapper.findByUid(12);
        for (CartVO cart : list) {
            System.err.println("cart = " + cart);
        }
    }

    @Test
    public void findById() {
        Cart cart = cartMapper.findById(3);
        System.err.println("cart = " + cart);
    }

    @Test
    public void findByIds() {
        Integer[] ids = new Integer[]{1, 3, 5};
        List<CartVO> list = cartMapper.findByIds(ids);
        System.err.println("list = " + list);
    }

}
