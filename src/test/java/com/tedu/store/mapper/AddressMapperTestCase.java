package com.tedu.store.mapper;

import com.tedu.store.entity.Address;
import com.tedu.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class AddressMapperTestCase {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void addnew() {
        Address address = new Address();
        address.setUid(2);
        address.setName("test");
        Integer integer = addressMapper.addnew(address);
        System.err.println("integer = " + integer);
        System.err.println("address = " + address);
    }

    @Test
    public void getCountByUid() {
        Integer count = addressMapper.getCountByUid(2);
        System.err.println("count = " + count);
    }
}
