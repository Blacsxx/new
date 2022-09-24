package com.tedu.store.controller;

import com.tedu.store.entity.Address;
import com.tedu.store.service.IAddressService;
import com.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 处理收货地址相关请求的控制器类
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController{
    @Autowired
    private IAddressService iAddressService;


    @PostMapping("/create")
    public ResponseResult<Void> create(Address address, HttpSession session){
        Integer uid = Integer.valueOf((Integer) session.getAttribute("id"));
        String username = String.valueOf(session.getAttribute("username"));
        address.setUid(uid);
        iAddressService.create(username,address);
        return new  ResponseResult<>(SUCCESS);
    }
}
