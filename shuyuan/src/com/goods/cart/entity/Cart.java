package com.goods.cart.entity;

import java.math.BigDecimal;

import com.goods.book.entity.Book;
import com.goods.user.entity.User;

/**
 * ���ﳵ��ʵ����
 * @author lenovo
 *
 */
public class Cart {
	   private String cartItemId;
	   private double subtotal;//С��
	   private int quantity;//����
	   private Book book; 
	   private User user;
	   
	 

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getSubtotal() {
			/*
			 * ����ֱ�ӳ˶�����decimal��ԭ�򣺼������
			 * ����������ʹ��ֻ��String�Ĺ�����
			 */
			BigDecimal b1 = new BigDecimal(book.getCurrPrice() + "");
			BigDecimal b2 = new BigDecimal(quantity + "");
			BigDecimal b3 = b1.multiply(b2);
			return b3.doubleValue();
		}

	public String getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	   
	   
}