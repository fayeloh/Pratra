package com.goods.cart.servies;

import java.sql.SQLException;
import java.util.List;

import com.fayeloh.tools.commons.CommonUtils;
import com.goods.cart.dao.CartDao;
import com.goods.cart.entity.Cart;

/**
 * ���ﳵ��ҵ���
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
	 * ��ѯ���ﳵ��Ŀ
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
	 * ��ѯ�ҵĹ��ﳵ
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
	 * ������Ŀ
	 * @param cart
	 */
	public void add(Cart cart){
		try {
			/*
			 * 1.��ѯ���û��Ĺ��ﳵ���Ƿ��д��飨��Ŀ��
			 */
			Cart _cart = cartDao.finByUidAndBid(cart.getUser().getUid(), cart.getBook().getBid());
			if(_cart!=null){
				//������ڴ��飬���´��������
				//�ɵ���Ŀ�������µ���Ŀ��
				int quantity = cart.getQuantity()+_cart.getQuantity();
				cartDao.updateQuantity(_cart.getCartItemId(), quantity);
			}else{
				//�������Ӵ���Ŀ,��Ҫ��������Ŀ��id
				cart.setCartItemId(CommonUtils.uuid());
				cartDao.addCartItem(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * �����޸Ĺ���
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
	 * ��������
	 * @param cartItemId
	 * @param quantity
	 * @return
	 */
	public Cart updateQuantity(String cartItemId,int quantity){
		try {
			/*
			 * �޸�����
			 */
			cartDao.updateQuantity(cartItemId, quantity);
			/*
			 * ���ҹ��ﳵ������
			 */
			return cartDao.findByCartItemId(cartItemId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
