package com.tedu.store.mapper;


import com.tedu.store.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    /**
     * @param categoryId 商品分类id
     * @param offset 起始 偏移量
     * @param count 获取数据最大量
     * @return 商品列表数据
     */
    List<Goods> findByCategoryId(@Param("categoryId") Integer categoryId, @Param("offset") Integer offset, @Param("count")Integer count);

    /**
     * 通过指定id获取商品的数据
     * @param id 商品id
     * @return 商品数据
     */
    Goods findById(Integer id);


    /**
     * 查询优先级最高的商品
     * @param count 查询商品数据的总条数
     * @return 优先级最高的商品数据列表
     */
    List<Goods> findByPriority(Integer count);
}
