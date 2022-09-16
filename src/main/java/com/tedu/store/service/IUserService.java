package com.tedu.store.service;

import com.tedu.store.entity.User;
import com.tedu.store.service.ex.DuplicateKeyException;
import com.tedu.store.service.ex.InsertException;

public interface IUserService {

    /**
     * 用户注册
     * @param user 用户的信息
     * @return 成功注册的用户数据
     * @throws DuplicateKeyException
     * @throws InsertException
     */
    User register(User user) throws DuplicateKeyException, InsertException;


}
