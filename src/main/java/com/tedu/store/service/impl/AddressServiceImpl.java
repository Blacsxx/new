package com.tedu.store.service.impl;

import com.tedu.store.entity.Address;
import com.tedu.store.entity.District;
import com.tedu.store.mapper.AddressMapper;
import com.tedu.store.service.IAddressService;
import com.tedu.store.service.IDistrictService;
import com.tedu.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

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

    @Override
    @Transactional
    public void setDefault(Integer uid, Integer id) {
        Address address = findById(id);
        if (address == null) {
            throw new AddressNotFoundException("尝试访问的收货地址不存在!");
        }
        if (address.getUid() != uid) {
            throw new AccessDeniedException("设置默认收货地址不存在,访问数据验证权限不通过!");
        }
        updateNonDefault(uid);
        updateDefault(id);
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        return findByUid(uid);
    }

    @Override
    @Transactional
    public void delete(Integer uid, Integer id) {
        Address address = findById(id);
        if (address == null) {
            throw new AddressNotFoundException("删除的地址不存在");
        }
        if (!address.getUid().equals(uid)) {
            throw new AccessDeniedException("用户访问权限未通过异常");
        }
        Integer isDefault = address.getIsDefault();
        deleteById(id);
        Integer count = getCountByUid(uid);
        if (count > 0 && isDefault == 1) {
            Integer last = findLastModified(uid).getId();
            setDefault(uid, last);
        }

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

    private List<Address> findByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        if (list == null) {
            throw new UserNotFoundException("用户地址为空!");
        }
        return list;
    }


    /**
     * 更改用户所有地址为非默认
     *
     * @param uid 用户id
     */
    private void updateNonDefault(Integer uid) {
        Integer integer = addressMapper.updateNonDefault(uid);
        if (integer < 0) {
            throw new UpdateException("更新用户所有默认地址异常");
        }
    }


    /**
     * 更改用户指定地址为默认
     *
     * @param id 用户指定地址id
     * @return 受影响的行数
     */
    private void updateDefault(Integer id) {
        Integer integer = addressMapper.updateDefault(id);
        if (integer != 1) {
            throw new UpdateException("更新用户默认地址异常");
        }
    }

    /**
     * 通过指定id获取收货地址数据
     *
     * @param id 指定的id
     * @return 收货地址数据
     */
    private Address findById(Integer id) {
        return addressMapper.findById(id);
    }

    /**
     * 查找最近修改的地址的数据
     *
     * @param uid 用户id
     * @return 地址数据
     */
    private Address findLastModified(Integer uid) {
        return addressMapper.findLastModified(uid);
    }


    /**
     * 删除指定id的地址数据
     *
     * @param id 地址数据的id
     */
    private void deleteById(Integer id) {
        Integer integer = addressMapper.deleteById(id);
        if (integer != 1) {
            throw new DeleteException("删除数据异常");
        }
    }
}
