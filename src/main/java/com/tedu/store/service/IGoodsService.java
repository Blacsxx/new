package com.tedu.store.service;

import com.tedu.store.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsService {

    /**
     * 获取指定分类id下所有商品的数据
     *
     * @param categoryId 商品分类id
     * @return 商品列表数据
     */
    List<Goods> getByCategoryId(Integer categoryId, Integer offset, Integer count);

    /**
     * 通过指定id获取商品的数据
     *
     * @param id 商品id
     * @return 商品数据
     */
    Goods getById(Integer id);

    /**
     * 查询优先级最高的商品
     * @param count 查询商品数据的总条数
     * @return 优先级最高的商品数据列表
     */
    List<Goods> getByPriority(Integer count);
}
