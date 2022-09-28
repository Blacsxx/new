package com.tedu.store.service;

import com.tedu.store.entity.Address;
import com.tedu.store.entity.User;
import com.tedu.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

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

    @Test
    public void fingByUid(){
        List<Address> list = iAddressService.getByUid(12);
        for (Address address : list) {
            System.out.println("address = " + address);
        }
    }

    @Test
    public void setDefault(){
        try {
            iAddressService.setDefault(11,13);
        } catch (ServiceException e) {
            System.err.println("e.getMessage() = " + e.getMessage());
            System.err.println(e.getClass());
        }
    }


    @Test
    public void delete(){
        try {
            iAddressService.delete(12,13);
        } catch (ServiceException e) {
            System.err.println("e.class = " + e.getClass());
            System.err.println("e.getMessage() = " + e.getMessage());
        }
    }
}
