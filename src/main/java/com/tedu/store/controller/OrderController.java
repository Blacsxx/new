package com.tedu.store.controller;

import com.tedu.store.entity.Order;
import com.tedu.store.service.IOrderService;
import com.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController{

    @Autowired
    private IOrderService orderService;

    @GetMapping("/create")
    public ResponseResult<Order> createOrder(HttpSession session,Integer addressId,Integer[] cartIds){
        Order order = orderService.createOrder(getIdBySession(session), session.getAttribute("username").toString(), addressId, cartIds);
        return new ResponseResult<>(SUCCESS,order);
    }
}
