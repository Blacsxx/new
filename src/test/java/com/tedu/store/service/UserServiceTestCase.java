package com.tedu.store.service;

import com.tedu.store.entity.User;
import com.tedu.store.service.ex.DuplicateKeyException;
import com.tedu.store.service.ex.InsertException;
import com.tedu.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserServiceTestCase {

    @Autowired
    private IUserService iuserService;

    @Test
    public void reg(){
        try {
            Date now = new Date();
            User user = new User();
            user.setUsername("Tom");
            user.setPassword("test");
            user.setGender(1);
            user.setPhone("1300000001");
            user.setEmail("haccc5@173.com");
            User register = iuserService.register(user);
            System.out.println("register = " + register);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
}
