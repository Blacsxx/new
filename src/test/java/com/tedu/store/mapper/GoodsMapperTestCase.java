package com.tedu.store.mapper;

import com.tedu.store.entity.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsMapperTestCase {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void findById(){
        Goods goods = goodsMapper.findById(10000019);
        System.err.println("goods = " + goods);
    }

    @Test
    public void findByCategoryId(){

    }

    @Test
    public void findByPriority(){
        List<Goods> list = goodsMapper.findByPriority(4);
        for (Goods goods : list) {
            System.err.println("goods = " + goods);
        }
    }
}
