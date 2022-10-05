package com.tedu.store.service.impl;

import com.tedu.store.entity.Goods;
import com.tedu.store.mapper.GoodsMapper;
import com.tedu.store.service.IGoodsService;
import com.tedu.store.service.ex.GoodsNotFoundException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getByCategoryId(Integer categoryId, Integer offset, Integer count) {
        return findByCategoryId(categoryId, offset, count);
    }

    @Override
    public Goods getById(Integer id) {
        return findById(id);
    }

    @Override
    public List<Goods> getByPriority(Integer count) {
        return findByPriority(count);
    }


    /**
     * @param categoryId 商品分类id
     * @param offset     起始 偏移量
     * @param count      获取数据最大量
     * @return 商品列表数据
     */
    private List<Goods> findByCategoryId(Integer categoryId, Integer offset, Integer count) {
        List<Goods> list = goodsMapper.findByCategoryId(categoryId, offset, count);
        if (list == null || list.size() == 0) {
            throw new GoodsNotFoundException("分类商品未找到");
        }
        return list;
    }

    /**
     * 通过指定id获取商品的数据
     *
     * @param id 商品id
     * @return 商品数据
     */
    private Goods findById(Integer id) {
        Goods goods = goodsMapper.findById(id);
        if (goods == null) {
            throw new GoodsNotFoundException("商品数据未找到");
        }
        return goods;
    }


    /**
     * 查询优先级最高的商品
     * @param count 查询商品数据的总条数
     * @return 优先级最高的商品数据列表
     */
    private List<Goods> findByPriority(Integer count) {
        return goodsMapper.findByPriority(count);
    }
}
