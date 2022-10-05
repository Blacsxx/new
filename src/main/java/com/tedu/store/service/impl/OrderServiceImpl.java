package com.tedu.store.service.impl;

import com.tedu.store.entity.Address;
import com.tedu.store.entity.Order;
import com.tedu.store.entity.OrderItem;
import com.tedu.store.mapper.OrderMapper;
import com.tedu.store.service.IAddressService;
import com.tedu.store.service.ICartService;
import com.tedu.store.service.IOrderService;
import com.tedu.store.service.ex.InsertException;
import com.tedu.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;

    @Override
    @Transactional
    public Order createOrder(Integer uid, String username, Integer addressId, Integer[] cartIds) throws InsertException {
        Date now = new Date();
        Long pay = 0L;

        List<CartVO> carts = cartService.getByIds(cartIds);
        List<OrderItem> ordersItems = new ArrayList<>();

        for (CartVO cart: carts) {
            pay+=cart.getNewPrice()*cart.getCount();
            OrderItem items = new OrderItem();
            items.setGoodsId(cart.getGid());
            items.setGoodsTitle(cart.getTitle());
            items.setGoodsImage(cart.getImage());
            items.setGoodsPrice(cart.getNewPrice());
            items.setGoodsCount(cart.getCount());
            items.setCreatedUser(username);
            items.setCreatedTime(now);
            items.setModifiedUser(username);
            items.setModifiedTime(now);
            ordersItems.add(items);
        }
        Order order = new Order();
        order.setUid(uid);
        order.setPay(pay);
        Address address =  addressService.getById(addressId);

        order.setRecvAddress(address.getAddress());
        order.setRecvName(address.getName());
        order.setRecvDistrict(address.getDistrict());
        order.setRecvPhone(address.getPhone());

        order.setOrderTime(now);

        order.setStatus(0);

        order.setCreatedTime(now);
        order.setCreatedUser(username);
        order.setModifiedTime(now);
        order.setModifiedUser(username);
        insertOrder(order);

        for(OrderItem items:ordersItems){
            items.setOid(order.getId());
            insertOrderItem(items);
        }

        return order;
    }


    /**
     * 插入用户订单数据
     *
     * @param order 订单数据
     * @return 受影响的行数
     */
    private void insertOrder(Order order) {
        Integer integer = orderMapper.insertOrder(order);
        if (integer != 1) {
            throw new InsertException("插入订单失败!");
        }

    }

    /**
     * 插入用户订单商品数据
     *
     * @param orderItem 商品数据
     * @return 受影响的行数
     */
    private void insertOrderItem(OrderItem orderItem) {
        Integer integer = orderMapper.insertOrderItem(orderItem);
        if (integer != 1) {
            throw new InsertException("插入订单商品数据失败!");
        }
    }
}
