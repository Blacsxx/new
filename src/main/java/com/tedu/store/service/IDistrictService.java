package com.tedu.store.service;

import com.tedu.store.entity.District;

import java.util.List;

/**
 * 省/市/区数据的业务接口
 */
public interface IDistrictService {
    /**
     * 根据父级代号获取子级的省/市/区的列表
     * @param parent 父级代号,如果需要获取省的列表,则父级代号为86
     * @return
     */
    List<District> getListByParent(String parent);

    /**
     * 根据代号获取省/市/区的详情
     * @param code 省/市/区的代号
     * @return 省/市/区的详情,如果没有匹配的数据,则返回null
     */
    District getByCode(String code);
}
