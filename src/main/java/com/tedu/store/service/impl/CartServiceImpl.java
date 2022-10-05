package com.tedu.store.service.impl;

import com.tedu.store.entity.Cart;
import com.tedu.store.mapper.CartMapper;
import com.tedu.store.service.ICartService;
import com.tedu.store.service.ex.AccessDeniedException;
import com.tedu.store.service.ex.CartNotFoundException;
import com.tedu.store.service.ex.InsertException;
import com.tedu.store.service.ex.UpdateException;
import com.tedu.store.vo.CartVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void addToCart(Cart cart, String username) throws UpdateException, InsertException {
        Cart byUidAndGid = findByUidAndGid(cart.getUid(), cart.getGid());
        Date date = new Date();
        System.err.println("byUidAndGid = " + byUidAndGid);
        if (byUidAndGid == null) {
            cart.setModifiedUser(username);
            cart.setCreatedUser(username);
            cart.setModifiedTime(date);
            cart.setCreatedTime(date);
            addNew(cart);
            return;
        }
        int i = cart.getCount() + byUidAndGid.getCount();
        System.err.println("i = " + i);
        updateCount(byUidAndGid.getId(), i);
    }

    @Override
    public void addCount(Integer id, Integer uid) throws CartNotFoundException, UpdateException, AccessDeniedException {
        Cart data = findById(id);
        if (data == null) {
            throw new CartNotFoundException("购物车数据不存在");
        }
        if (!data.getUid().equals(uid)) {
            throw new AccessDeniedException("访问数据权限验证不通过");
        }
        Integer count = data.getCount();
        count++;
        updateCount(id, count);
    }


    @Override
    public List<CartVO> getByUid(Integer uid) {
        return findByUid(uid);
    }

    @Override
    public List<CartVO> getByIds(Integer[] ids) {
        return findByIds(ids);
    }


    /**
     * 添加购物车内商品数据
     *
     * @param cart 商品数据
     */
    private void addNew(Cart cart) {
        Integer integer = cartMapper.addNew(cart);
        if (integer == null) {
            throw new InsertException("增加购物车商品出现异常!");
        }
    }

    /**
     * 更新购物车内商品数量
     *
     * @param id    购物车数据id
     * @param count 商品新数量
     */
    private void updateCount(Integer id, Integer count) {
        Integer integer = cartMapper.updateCount(id, count);
        if (integer == null) {
            throw new UpdateException("更新商品数量出现未知异常!");
        }
    }

    /**
     * 查找购物车内商品数据
     *
     * @param uid 用户id
     * @param gid 商品id
     * @return 购物车内商品数据, 没有返回null
     */
    private Cart findByUidAndGid(Integer uid, Integer gid) {
        return cartMapper.findByUidAndGid(uid, gid);

    }

    /**
     * 根据购物车id查询购物车商品数据
     *
     * @param id 购物车数据id
     * @return 购物车内商品数据, 没有返回null
     */
    private Cart findById(Integer id) {
        return cartMapper.findById(id);
    }


    /**
     * 根据用户id查询用户购物车数据列表
     * @param uid 用户id
     * @return 购物车数据列表
     */
    private List<CartVO> findByUid(Integer uid) {
        return cartMapper.findByUid(uid);
    }


    /**
     * 根据购物车提交用户ids数组,查询用户购物车数据列表
     * @param ids 用户提交的ids数组
     * @return 购物车提交的数据列表
     */
    private List<CartVO> findByIds(Integer[] ids) {
        return cartMapper.findByIds(ids);
    }

}
