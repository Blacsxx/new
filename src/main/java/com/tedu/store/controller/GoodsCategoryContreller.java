package com.tedu.store.controller;

import com.tedu.store.entity.GoodsCategory;
import com.tedu.store.service.IGoodsCategoryService;
import com.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class GoodsCategoryContreller extends BaseController{
    @Autowired
    private IGoodsCategoryService iGoodsCategoryService;

    @GetMapping("/list/{parentId}")
    public ResponseResult<List<GoodsCategory>> getList(@PathVariable("parentId") Integer parentId){
        List<GoodsCategory> list = iGoodsCategoryService.getByParent(parentId);
        return new ResponseResult<>(SUCCESS,list);
    }
}
