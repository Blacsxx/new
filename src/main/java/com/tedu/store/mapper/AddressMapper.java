package com.tedu.store.mapper;

import com.tedu.store.entity.Address;


import java.util.List;

public interface AddressMapper {

    /**
     *增加新的收货地址
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    Integer addnew(Address address);

    /**
     * 更改用户所有地址为非默认
     * @param uid 用户id
     * @return 受影响的行数
     */
    Integer updateNonDefault(Integer uid);


    /**
     * 更改用户指定地址为默认
     * @param id 用户指定地址id
     * @return 受影响的行数
     */
    Integer updateDefault(Integer id);

    /**
     *根据用户id查询地址数据总条数
     * @param uid 用户id
     * @return 数据总条数
     */
    Integer getCountByUid(Integer uid);


    /**
     * 获取某个用户全部地址列表
     * @param uid 用户的ID
     * @return 地址列表
     */
    List<Address> findByUid(Integer uid);

    /**
     * 通过指定id获取收货地址数据
     * @param id 指定的id
     * @return 收货地址数据
     */
    Address findById(Integer id);

    /**
     * 查找最近修改的地址的数据
     * @param uid 用户id
     * @return 地址数据
     */
    Address findLastModified(Integer uid);


    /**
     * 删除指定id的地址数据
     * @param id 地址数据的id
     * @return 受影响的行数
     */
    Integer deleteById(Integer id);
}
