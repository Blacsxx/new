package com.tedu.store.mapper;

import com.tedu.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserMapperTestCase {

    @Autowired
    private  UserMapper userMapper;

    @Test
    public void addnew(){
        Date now = new Date();
        User user = new User();
        user.setUsername("admin");
        user.setPassword("test");
        user.setGender(1);
        user.setPhone("13000000000");
        user.setEmail("hanqi285@173.com");
        user.setSalt("md5");
        user.setIsDelete(0);
        user.setCreatedUser("admin");
        user.setCreatedTime(now);
        user.setModifiedUser("admin");
        user.setModifiedTime(now);
        Integer addnew = userMapper.addnew(user);
        System.out.println("addnew = " + addnew);
    }

    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("admin");
        System.out.println("user = " + user);
    }
}
