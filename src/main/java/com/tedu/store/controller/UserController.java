package com.tedu.store.controller;

import com.tedu.store.entity.User;
import com.tedu.store.service.IUserService;
import com.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @RequestMapping ("/reg.do")
    public ResponseResult<Void> handleReg(User user)throws Exception{
        userService.register(user);
        return new ResponseResult<Void>(SUCCESS);
    }
}
