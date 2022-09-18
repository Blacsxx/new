package com.tedu.store.controller;

import com.tedu.store.entity.User;
import com.tedu.store.service.IUserService;
import com.tedu.store.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @PostMapping("/reg.do")
    public ResponseResult<Void> handleReg(User user) throws Exception {
        userService.register(user);
        return new ResponseResult<Void>(SUCCESS);
    }

    @PostMapping("/login.do")
    public ResponseResult<Void> handleLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        User user = userService.login(username, password);
        session.setAttribute("id", user.getId());
        session.setAttribute("username", user.getUsername());
        return new ResponseResult<Void>(SUCCESS);
    }

    @PostMapping("/password.do")
    public ResponseResult<Void> handleChangePassword(@RequestParam("old_password") String oldPassword, @RequestParam("new_password") String newPassword, HttpSession session) {
        userService.changePassword(Integer.valueOf(session.getAttribute("id").toString()), oldPassword, newPassword);
        return new ResponseResult<Void>(SUCCESS);
    }
}
