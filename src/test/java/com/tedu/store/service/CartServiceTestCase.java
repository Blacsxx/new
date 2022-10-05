package com.tedu.store.service;

import com.tedu.store.entity.Cart;
import com.tedu.store.entity.District;
import com.tedu.store.service.ex.InsertException;
import com.tedu.store.service.ex.ServiceException;
import com.tedu.store.service.ex.UpdateException;
import com.tedu.store.vo.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CartServiceTestCase {

    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart() {
        try {
            Cart cart = new Cart();

            cart.setGid(2);
            cart.setUid(3);
            cart.setCount(3);
            cart.setPrice(66666L);
            cart.setCreatedUser("admin");
            cart.setModifiedUser("admin");
            cart.setCreatedTime(new Date());
            cart.setModifiedTime(new Date());

            cartService.addToCart(cart, "test");
        } catch (ServiceException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    @Test
    public void addCount() {
        try {
            cartService.addCount(5,1);
        } catch (ServiceException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    @Test
    public void getByUid() {
        List<CartVO> list = cartService.getByUid(12);
        for (CartVO cartVO : list) {
            System.err.println("cartVO = " + cartVO);
        }
    }

}
