package com.tedu.store.service;

import com.tedu.store.entity.Goods;
import com.tedu.store.entity.GoodsCategory;
import com.tedu.store.service.ex.GoodsCategoryNotFoundException;
import com.tedu.store.service.ex.GoodsNotFoundException;

import java.util.List;

public interface IGoodsCategoryService {

    /**
     * 获取指定腹肌分类下的所有子集商品数据
     * @param parentId 父类id
     * @return 子集数据集合
     */
    List<GoodsCategory> getByParent(Integer parentId) throws GoodsCategoryNotFoundException;
}
