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
     *
     * @param id           用户id
     * @param password     新密码
     * @param modifiedUser 记录修改人
     * @param modifiedTime 记录修改时间
     * @return 受影响行数
     */
    Integer updatePassword(@RequestParam("id") Integer id, @RequestParam("password") String password, @RequestParam("modifiedUser") String modifiedUser, @RequestParam("modifiedTime") Date modifiedTime);

    /**
     * 修改用户上传头像路径
     *
     * @param id 用户id
     * @param avatar 头像图片物理位置
     * @param modifiedUser 记录修改人
     * @param modifiedTime 记录修改时间
     * @return 受影响行数
     */
    Integer updateAvatar(@RequestParam("id") Integer id, @RequestParam("avatar") String avatar, @RequestParam("modifiedUser") String modifiedUser, @RequestParam("modifiedTime") Date modifiedTime);

    /**
     * 修改用户信息(不含用户名,密码和头像)
     *
     * @param user 用户信息
     * @return 受影响行数
     */
    Integer updateInfo(User user);

    /**
     * 根据id查询用户密码
     *
     * @param id 用户id
     * @return 用户信息
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
