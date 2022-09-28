package com.tedu.store.service.impl;

import com.tedu.store.entity.Goods;
import com.tedu.store.mapper.GoodsMapper;
import com.tedu.store.service.IGoodsService;
import com.tedu.store.service.ex.GoodsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getByCategoryId(Integer categoryId) {
        return findByCategoryId(categoryId);
    }

    @Override
    public Goods getById(Integer id) {
        return findById(id);
    }

    /**
     * 获取指定分类id下所有商品的数据
     * @param categoryId 商品分类id
     * @return 商品列表数据
     */
    private List<Goods> findByCategoryId(Integer categoryId) {
        List<Goods> list = goodsMapper.findByCategoryId(categoryId);
        if (list == null || list.size() == 0) {
            throw new GoodsNotFoundException("分类商品未找到");
        }
        return list;
    }

    /**
     * 通过指定id获取商品的数据
     * @param id 商品id
     * @return 商品数据
     */
     private Goods findById(Integer id){
         Goods goods = goodsMapper.findById(id);
         if (goods == null) {
             throw new GoodsNotFoundException("商品数据未找到");
         }
         return goods;
    }
}
