package com.tedu.store.mapper;

import com.tedu.store.entity.Address;

public interface AddressMapper {

    /**
     *增加新的收货地址
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    Integer addnew(Address address);

    /**
     *根据用户id查询地址数据总条数
     * @param uid 用户id
     * @return 数据总条数
     */
    Integer getCountByUid(Integer uid);
}
