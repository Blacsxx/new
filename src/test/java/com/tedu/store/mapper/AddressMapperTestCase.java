package com.tedu.store.mapper;

import com.tedu.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void findByUid() {
        List<Address> list = addressMapper.findByUid(12);
        for (Address address : list) {
            System.out.println("address = " + address);
        }
    }

    @Test
    public void updateNonDefault(){
        Integer integer = addressMapper.updateNonDefault(12);
        System.out.println("integer = " + integer);
    }

    @Test
    public void updateDefault(){
        Integer integer = addressMapper.updateDefault(15);
        System.out.println("integer = " + integer);
    }

    @Test
    public void findById(){
        Address address = addressMapper.findById(12);
        System.err.println("address = " + address);
    }

    @Test
    public void deleteById(){
        Integer integer = addressMapper.deleteById(14);
        System.out.println("integer = " + integer);
    }

    @Test
    public void findLastModified(){
        Address lastModified = addressMapper.findLastModified(12);
        System.err.println("lastModified = " + lastModified);
    }
}
