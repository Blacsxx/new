package com.tedu.store.service;

import com.tedu.store.entity.Order;
import com.tedu.store.service.ex.InsertException;

/**
 * 订单与订单商品的业务层接口
 */
public interface IOrderService {

    /**
     * 创建订单
     * @param uid 当前登录用户id
     * @param username 当前登录用户名
     * @param addressId 订单选择的收货地址id
     * @param cartIds 订单中的商品在购物车中的数据id
     * @return 成功创建的订单
     */
    Order createOrder(Integer uid,String username,Integer addressId,Integer[] cartIds) throws InsertException;
}
