package com.tedu.store.mapper;

import com.tedu.store.entity.GoodsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsCategoryMapperTestCase {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Test
    public void findById(){
        List<GoodsCategory> list = goodsCategoryMapper.findByParent(89);
        for (GoodsCategory item : list) {
            System.err.println("item = " + item);
        }
    }


}
