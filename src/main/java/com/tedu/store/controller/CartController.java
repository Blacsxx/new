package com.tedu.store.controller;

import com.tedu.store.entity.Cart;
import com.tedu.store.service.ICartService;
import com.tedu.store.util.ResponseResult;
import com.tedu.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车控制器类
 */
@RestController
@RequestMapping("/cart")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;

    @PostMapping("/add_to_cart")
    public ResponseResult<Void> addToCart(HttpSession session, Cart cart) {
        System.err.println("cart = " + cart);
        Integer id = getIdBySession(session);
        String username = session.getAttribute("username").toString();
        cart.setUid(id);
        cartService.addToCart(cart, username);
        return new ResponseResult<Void>(SUCCESS);
    }

    @GetMapping("/list")
    public ResponseResult<List<CartVO>> getByUserId(HttpSession session){
        List<CartVO> list = cartService.getByUid(getIdBySession(session));
        return new ResponseResult<List<CartVO>>(SUCCESS,list);
    }
    
    @GetMapping("/add_count")
    public ResponseResult<Void> addCount(@RequestParam("id") Integer id, HttpSession session){
        Integer uid = getIdBySession(session);
        cartService.addCount(id,uid);
        return new ResponseResult<>(SUCCESS);
    }

    @GetMapping("/get_by_ids")
    public ResponseResult<List<CartVO>> getByIds(@RequestParam("cart_id") Integer[] ids){
        List<CartVO> list = cartService.getByIds(ids);
        return new ResponseResult<List<CartVO>>(SUCCESS,list);
    }
}
