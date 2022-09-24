package com.tedu.store.mapper;


import com.tedu.store.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DistrictMapperTestCase {

    @Autowired
    DistrictMapper districtMapper;


    @Test
    public void findByParent(){
        List<District> byParent = districtMapper.findByParent("86");
        System.out.println("byParent = " + byParent);
    }

    @Test
    public void findByCode(){
        District byCode = districtMapper.findByCode("330102");
        System.out.println("byCode = " + byCode);
    }

}
