package com.tedu.store.service;


import com.tedu.store.entity.Cart;
import com.tedu.store.service.ex.AccessDeniedException;
import com.tedu.store.service.ex.CartNotFoundException;
import com.tedu.store.service.ex.InsertException;
import com.tedu.store.service.ex.UpdateException;
import com.tedu.store.vo.CartVO;

import java.util.List;

public interface ICartService {

    /**
     * 添加商品到购物车
     * @param cart 商品信息
     * @param username 操作用户
     */
    void addToCart(Cart cart,String username)throws UpdateException, InsertException;

    /**
     * 增加购物车商品数量
     * @param id 购物车商品id
     * @param uid 使用者的uid
     */
    void addCount(Integer id,Integer uid)throws CartNotFoundException,UpdateException, AccessDeniedException;

    /**
     * 根据用户id查询用户购物车数据列表
     * @param uid 用户id
     * @return 购物车数据列表
     */
    List<CartVO> getByUid(Integer uid);


    /**
     * 根据购物车提交用户ids数组,查询用户购物车数据列表
     * @param ids 用户提交的ids数组
     * @return 购物车提交的数据列表
     */
    List<CartVO> getByIds(Integer[] ids);

}
