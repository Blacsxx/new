package com.tedu.store.service.impl;

import com.tedu.store.entity.Address;
import com.tedu.store.entity.District;
import com.tedu.store.mapper.AddressMapper;
import com.tedu.store.service.IAddressService;
import com.tedu.store.service.IDistrictService;
import com.tedu.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private IDistrictService iDistrictService;


    @Override
    public Address create(String username, Address address) throws InsertException {
        //同过uid得到用户id,并得到用户收货地址数量
        Integer count = getCountByUid(address.getUid());
        //判断数量是否为0
        // if (count == 0){
        //     //是:首次创建,改地址默认
        //     address.setIsDefault(1);
        // }else {
        //     //否:非默认
        //     address.setIsDefault(0);
        // }
        address.setIsDefault(count == 0 ? 1 : 0);
        //todo 处理district:根据省市区的代号处理
        String district = getDistrict(address.getProvince(), address.getCity(), address.getArea());
        address.setDistrict(district);
        //封装日志
        Date date = new Date();
        address.setCreatedUser(username);
        address.setCreatedTime(date);
        address.setModifiedUser(username);
        address.setModifiedTime(date);
        //执行创建新地址41
        addnew(address);
        return address;
    }

    /**
     * 增加新的收货地址
     *
     * @param address 收货地址数据
     */
    private void addnew(Address address) {
        Integer integer = addressMapper.addnew(address);
        if (integer == null) {
            throw new InsertException("添加地址出现未知错误!");
        }
    }

    /**
     * 根据用户id查询地址数据总条数
     *
     * @param uid 用户id
     * @return 数据总条数
     */
    private Integer getCountByUid(Integer uid) {
        return addressMapper.getCountByUid(uid);
    }

    /**
     * 根据省市区的代号获取名称
     *
     * @param province 省的代号
     * @param city     市的代号
     * @param area     区的代号
     * @return 代码名称
     */
    private String getDistrict(String province, String city, String area) {
        String provinceName = null;
        String cityName = null;
        String areaName = null;
        District p = iDistrictService.getByCode(province);
        District c = iDistrictService.getByCode(city);
        District a = iDistrictService.getByCode(area);
        if (p != null) {
            provinceName = p.getName();
        }
        if (p != null) {
            cityName = c.getName();
        }
        if (p != null) {
            areaName = a.getName();
        }
        return provinceName + cityName + areaName;
    }
}
