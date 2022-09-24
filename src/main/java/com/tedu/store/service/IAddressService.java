package com.tedu.store.service;

import com.tedu.store.entity.Address;
import com.tedu.store.service.ex.InsertException;

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
}
