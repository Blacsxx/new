package com.tedu.store.mapper;

import com.tedu.store.entity.GoodsCategory;

import java.util.List;

public interface GoodsCategoryMapper {

    /**
     * 获取指定腹肌分类下的所有子集商品数据
     * @param parentId 父类id
     * @return 子集数据集合
     */
    List<GoodsCategory> findByParent(Integer parentId);
}
