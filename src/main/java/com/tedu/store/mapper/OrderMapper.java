package com.tedu.store.mapper;

import com.tedu.store.entity.Order;
import com.tedu.store.entity.OrderItem;

public interface OrderMapper {
    /**
     * 插入用户订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入用户订单商品数据
     * @param orderItem 商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);
}
