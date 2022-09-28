package com.tedu.store.service;

import com.tedu.store.entity.Address;
import com.tedu.store.service.ex.DeleteException;
import com.tedu.store.service.ex.InsertException;

import java.util.List;

/**
 * 收货地址的业务接口
 */
public interface IAddressService {

    /**
     * 创建新收货地址
     * @param username 当前执行人
     * @param address 收货地址信息
     * @return 受影响行数
     * @throws InsertException 插入异常
     */
    Address create(String username, Address address)throws InsertException;

    /**
     * 获取某个用户全部地址列表
     * @param uid 用户的ID
     * @return 地址列表
     */
    List<Address> getByUid(Integer uid);

    /**
     * 设置用户指定地址数据为默认
     * @param uid 用户id
     * @param id 用户指定地址数据
     */
    void setDefault(Integer uid,Integer id);


    /**
     * 删除用户数据
     * @param uid 用户id
     * @param id 地址数据id
     */
    void delete(Integer uid,Integer id)throws DeleteException;
}
