package com.tedu.store.controller;

import com.tedu.store.entity.Goods;
import com.tedu.store.service.IGoodsService;
import com.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    @Autowired
    private IGoodsService iGoodsService;

    @GetMapping("/list/{categoryId}")
    public ResponseResult<List<Goods>> getGoodsList(@PathVariable("categoryId") Integer categoryId){
        List<Goods> list = iGoodsService.getByCategoryId(categoryId,0,4);
        return new ResponseResult<List<Goods>>(SUCCESS,list);
    }

    @GetMapping("/details/{id}")
    public ResponseResult<Goods> getDetails(@PathVariable("id") Integer id){
        Goods goods = iGoodsService.getById(id);
        return new ResponseResult<Goods>(SUCCESS,goods);
    }

    @GetMapping("/hot")
    public ResponseResult<List<Goods>> getHotGoods(){
        List<Goods> list = iGoodsService.getByPriority(4);
        return new ResponseResult<List<Goods>>(SUCCESS,list);
    }
}
