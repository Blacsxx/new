package com.tedu.store.service;

import com.tedu.store.entity.User;
import com.tedu.store.service.ex.*;
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
            user.setUsername("test1");
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


    @Test
    public void login(){
        try {
            User login = iuserService.login("test1", "test");
            System.out.println("login = " + login);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void changePassword(){
        try {
            iuserService.changePassword(12,"test","test");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
}
