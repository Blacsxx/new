package com.tedu.store.service.impl;


import com.tedu.store.entity.GoodsCategory;
import com.tedu.store.mapper.GoodsCategoryMapper;
import com.tedu.store.service.IGoodsCategoryService;
import com.tedu.store.service.ex.GoodsCategoryNotFoundException;
import com.tedu.store.service.ex.GoodsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements IGoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategory> getByParent(Integer parentId) throws GoodsCategoryNotFoundException {
        return findByParent(parentId);
    }

    /**
     * 获取指定腹肌分类下的所有子集商品数据
     *
     * @param parentId 父类id
     * @return 子集数据集合
     */
    private List<GoodsCategory> findByParent(Integer parentId) {
        List<GoodsCategory> list = goodsCategoryMapper.findByParent(parentId);
        if (list == null || list.size() == 0) {
            throw new GoodsCategoryNotFoundException("商品数据不存在");
        }
        return list;
    }
}
