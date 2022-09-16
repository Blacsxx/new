package com.tedu.store.service.impl;

import com.tedu.store.entity.User;
import com.tedu.store.mapper.UserMapper;
import com.tedu.store.service.IUserService;
import com.tedu.store.service.ex.DuplicateKeyException;
import com.tedu.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 处理业务层的实现类
 */

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User register(User user) throws DuplicateKeyException, InsertException {
        User byUsername = findByUsername(user.getUsername());
        if (byUsername == null) {
            //是:用户名不存在,允许注册,则处理密码加密

            //补充 非用户提交数据
            user.setIsDelete(0);
            Date now = new Date();
            user.setCreatedUser(user.getUsername());
            user.setCreatedTime(now);
            user.setModifiedUser(user.getUsername());
            user.setModifiedTime(now);
            //加密-1:获取随机的UUID作为盐值
            String salt = UUID.randomUUID().toString().toUpperCase();
            //加密-2:获取用户提交的原始密码
            String userPassword = user.getPassword();
            //机密-3:基于原始密码和盐值执行加密,获取通过MD5加密后的密码
            String md5Password = getMD5Password(userPassword,salt);
            //加密-4:将加密后的密码封装在user对象中
            user.setPassword(md5Password);
            user.setSalt(salt);
            //执行注册
            addnew(user);
            return user;
        } else {
            throw new DuplicateKeyException("注册失败!用户名" + user.getUsername() + "已被占用");
        }
    }


    /**
     * 获取md5加密密码
     * @param userPassword 原密码
     * @param salt 盐值
     * @return 得到加密(MD5)的密码
     */
    private String getMD5Password(String userPassword,String salt){
        // 盐值 拼接 原密码 拼接 盐值
        //循环执行10次 摘要运算
        //返回摘要结果
        String src = salt + userPassword +salt;
        for (int i = 0; i < 10; i++) {
            src = DigestUtils.md5DigestAsHex(src.getBytes()).toUpperCase();
        }
        return src;
    }

    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响行数
     * @throws InsertException
     */
    private void addnew(User user) {
        Integer addnew = userMapper.addnew(user);
        if (addnew != 1) {
            throw new InsertException("增加用户时出现未知错误");
        }

    }

    ;

    /**
     * 根据用户名查询用户数据
     *
     * @param username 用户名
     * @return 匹配的用户数据, 如果没有用匹配的用户数据则返回null
     */
    private User findByUsername(String username) {
         return userMapper.findByUsername(username);
    }

    ;
}
