package com.tedu.store.mapper;

import com.tedu.store.entity.Cart;
import com.tedu.store.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {

    /**
     * 添加购物车内商品数据
     * @param cart 商品数据
     * @return 受影响行数
     */
    Integer addNew(Cart cart);

    /**
     * 更新购物车内商品数量
     * @param id 购物车数据id
     * @param count 商品新数量
     * @return 受影响行数
     */
    Integer updateCount(@Param("id") Integer id,@Param("count") Integer count);

    /**
     * 查找购物车内商品数据
     * @param uid 用户id
     * @param gid 商品id
     * @return 购物车内商品数据,没有返回null
     */
    Cart findByUidAndGid(@Param("uid") Integer uid,@Param("gid") Integer gid);

    /**
     * 根据购物车id查询购物车商品数据
     * @param id 购物车数据id
     * @return 购物车内商品数据,没有返回null
     */
    Cart findById(Integer id);

    /**
     * 根据用户id查询用户购物车数据列表
     * @param uid 用户id
     * @return 购物车数据列表
     */
    List<CartVO> findByUid(Integer uid);

    /**
     * 根据购物车提交用户ids数组,查询用户购物车数据列表
     * @param ids 用户提交的ids数组
     * @return 购物车提交的数据列表
     */
    List<CartVO> findByIds(Integer[] ids);
}
