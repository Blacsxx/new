package com.tedu.store.mapper;


import com.tedu.store.entity.Goods;

import java.util.List;

public interface GoodsMapper {


    /**
     * 获取指定分类id下所有商品的数据
     * @param categoryId 商品分类id
     * @return 商品列表数据
     */
    List<Goods> findByCategoryId(Integer categoryId);

    /**
     * 通过指定id获取商品的数据
     * @param id 商品id
     * @return 商品数据
     */
    Goods findById(Integer id);
}
