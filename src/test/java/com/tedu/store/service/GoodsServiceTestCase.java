package com.tedu.store.service;


import com.tedu.store.entity.Goods;
import com.tedu.store.entity.GoodsCategory;
import com.tedu.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsServiceTestCase {

    @Autowired
    private IGoodsService goodsService;

    @Test
    public void getByPriority(){
        List<Goods> list = goodsService.getByPriority(5);
        for (Goods goods : list) {
            System.err.println("goods = " + goods);
        }
    }


}
