package com.tedu.store.service;

import com.tedu.store.entity.User;
import com.tedu.store.service.ex.*;

public interface IUserService {

    /**
     * 用户注册
     * @param user 用户的信息
     * @return 成功注册的用户数据
     * @throws DuplicateKeyException
     * @throws InsertException
     */
    User register(User user) throws DuplicateKeyException, InsertException;


    /**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return 数据库中的用户信息
     * @throws UserNotFoundException 用户未找到
     * @throws PasswordNotMatchException 密码不正确
     */
    User login(String username,String password) throws UserNotFoundException, PasswordNotMatchException;

    /**
     * 修改密码
     * @param id 用户id
     * @param oldPassword
     * @param newPassword
     * @throws UserNotFoundException
     * @throws PasswordNotMatchException
     * @throws UpdateException
     */
    void changePassword(Integer id,String oldPassword,String newPassword)throws UserNotFoundException, PasswordNotMatchException, UpdateException;

    /**
     * 修改用户信息
     * @param user 用户资料
     */
    void changeInfo(User user)throws UserNotFoundException,UpdateException;

    /**
     * 修改用户头像
     * @param id
     * @param avatar
     */
    void changeAvatar(Integer id ,String avatar)throws UserNotFoundException,UpdateException;

    /**
     *根据id查询用户密码
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    User getById(Integer id)throws UserNotFoundException;
}
