package com.tedu.store.service;

import com.tedu.store.entity.Address;
import com.tedu.store.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DistrictServiceTestCase {

    @Autowired
    private IDistrictService istrictService;

    @Test
    public void getListByParent(){
        List<District> listByParent = istrictService.getListByParent("210000");
        System.err.println("Begin");
        for (District district : listByParent) {
            System.err.println("district = " + district);
        }
        System.err.println("End");
    }

    @Test
    public void getByCode(){
        District byCode = istrictService.getByCode("210000");
        System.out.println("byCode = " + byCode);
    }
}
