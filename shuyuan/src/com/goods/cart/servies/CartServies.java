package com.goods.cart.servies;

import java.sql.SQLException;
import java.util.List;

import com.fayeloh.tools.commons.CommonUtils;
import com.goods.cart.dao.CartDao;
import com.goods.cart.entity.Cart;

/**
 * 购物车的业务层
 * @author lenovo
 *
 */
public class CartServies {
	private CartDao cartDao = new CartDao();
	public Object[] print(){
		try {
			return cartDao.print();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * 查询购物车条目
	 * @param cartItemIds
	 * @return
	 */
	public List<Cart> loadCart(String cartItemIds){
		try {
			return cartDao.loadCart(cartItemIds);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询我的购物车
	 * @param uid
	 * @return
	 */
	public List<Cart> myCart(String uid){
		try {
			return cartDao.findByUser(uid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 增加条目
	 * @param cart
	 */
	public void add(Cart cart){
		try {
			/*
			 * 1.查询此用户的购物车中是否有此书（条目）
			 */
			Cart _cart = cartDao.finByUidAndBid(cart.getUser().getUid(), cart.getBook().getBid());
			if(_cart!=null){
				//如果存在此书，更新此书的数量
				//旧的条目数加上新的条目数
				int quantity = cart.getQuantity()+_cart.getQuantity();
				cartDao.updateQuantity(_cart.getCartItemId(), quantity);
			}else{
				//否则增加此条目,还要增加新条目的id
				cart.setCartItemId(CommonUtils.uuid());
				cartDao.addCartItem(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * 批量修改功能
	 * @param cartItemIds
	 */
	public void batchDelete(String cartItemIds){
		try {
			cartDao.batchDelete(cartItemIds);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 更改数量
	 * @param cartItemId
	 * @param quantity
	 * @return
	 */
	public Cart updateQuantity(String cartItemId,int quantity){
		try {
			/*
			 * 修改数量
			 */
			cartDao.updateQuantity(cartItemId, quantity);
			/*
			 * 查找购物车的数量
			 */
			return cartDao.findByCartItemId(cartItemId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
