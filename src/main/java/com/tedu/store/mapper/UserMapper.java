package com.tedu.store.mapper;

import com.tedu.store.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public interface UserMapper {

    /**
     * 插入用户数据
     *
     * @param user 用户数据
     * @return 受影响行数
     */
    Integer addnew(User user);

    /**
     * 根据id修改用户密码
     * @param id 用户id
     * @param password 新密码
     * @param modifiedUser 记录修改人
     * @param modifiedTime 记录修改时间
     * @return 受影响行数
     */
    Integer updatePassword(@RequestParam("id") Integer id, @RequestParam("password") String password, @RequestParam("modifiedUser") String modifiedUser, @RequestParam("modifiedTime") Date modifiedTime);

    /**
     * 根据id查询用户密码
     * @param id 用户id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据用户名查询用户数据
     *
     * @param username 用户名
     * @return 匹配的用户数据, 如果没有用匹配的用户数据则返回null
     */
    User findByUsername(String username);
}
