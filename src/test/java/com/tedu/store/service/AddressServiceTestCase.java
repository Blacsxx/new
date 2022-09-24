package com.tedu.store.service;

import com.tedu.store.entity.Address;
import com.tedu.store.entity.User;
import com.tedu.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class AddressServiceTestCase {

    @Autowired
    private IAddressService iAddressService;

    @Test
    public void creat(){
        Address address = new Address();
        address.setUid(2);
        address.setName("张三");
        address.setProvince("449999");
        address.setCity("440300");
        address.setArea("440305");
        Address address1 = iAddressService.create("root", address);
        System.out.println("address1 = " + address1);
    }
}
