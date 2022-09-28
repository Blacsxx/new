package com.tedu.store.controller;

import com.tedu.store.entity.Address;
import com.tedu.store.entity.District;
import com.tedu.store.service.IAddressService;
import com.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping("/list")
    public ResponseResult<List<Address>> getListByUid(HttpSession session){
        Integer uid = getIdBySession(session);
        List<Address> list = iAddressService.getByUid(uid);
        return new ResponseResult<List<Address>>(SUCCESS,list);
    }

    @GetMapping("/default/{id}")
    public ResponseResult<Void> setDefault(HttpSession session,@PathVariable("id") Integer id){
        iAddressService.setDefault(getIdBySession(session),id);
        return new ResponseResult<>(SUCCESS);
    }

    @GetMapping("/delete/{id}")
    public ResponseResult<Void> deleteById(HttpSession session,@PathVariable("id") Integer id){
        iAddressService.delete(getIdBySession(session),id);
        return new ResponseResult<>(SUCCESS);
    }

}
