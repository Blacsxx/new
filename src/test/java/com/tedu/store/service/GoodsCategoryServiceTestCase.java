package com.tedu.store.service;


import com.tedu.store.entity.GoodsCategory;
import com.tedu.store.service.ex.GoodsNotFoundException;
import com.tedu.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsCategoryServiceTestCase {

    @Autowired
    private IGoodsCategoryService iGoodsCategoryService;

    @Test
    public void getByParent(){
        try {
            List<GoodsCategory> list = iGoodsCategoryService.getByParent(9999);
            for(GoodsCategory category:list){
                System.err.println("category = " + category);
            }
        } catch (ServiceException e) {
            System.err.println("e.getMessage() = " + e.getMessage());
        }
    }


}
