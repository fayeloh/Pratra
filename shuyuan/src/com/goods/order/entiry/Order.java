package com.goods.order.entiry;

import java.util.List;

import com.goods.user.entity.User;

/**
 * 订单的实体类
 * @author lenovo
 *
 */
public class Order {
	  private String oid;//主键
	  private String ordertime;//下订单的时间
	  private double total;//总计
	  private int status;//状态 1.已下单未付款 2.已付款未发货 3.已发货未确认 4.。。。
	  private String address;
	  private User own;
	  private List<OrderItem> orderItemList;
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getOwn() {
		return own;
	}
	public void setOwn(User own) {
		this.own = own;
	}
}
