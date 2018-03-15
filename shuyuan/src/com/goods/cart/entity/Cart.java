package com.goods.cart.entity;

import java.math.BigDecimal;

import com.goods.book.entity.Book;
import com.goods.user.entity.User;

/**
 * 购物车的实体类
 * @author lenovo
 *
 */
public class Cart {
	   private String cartItemId;
	   private double subtotal;//小计
	   private int quantity;//本数
	   private Book book; 
	   private User user;
	   
	 

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getSubtotal() {
			/*
			 * 不用直接乘而是用decimal，原因：减少误差
			 * 条件：必须使用只含String的构造器
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