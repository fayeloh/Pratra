package com.goods.order.entiry;

import java.util.List;

import com.goods.user.entity.User;

/**
 * ������ʵ����
 * @author lenovo
 *
 */
public class Order {
	  private String oid;//����
	  private String ordertime;//�¶�����ʱ��
	  private double total;//�ܼ�
	  private int status;//״̬ 1.���µ�δ���� 2.�Ѹ���δ���� 3.�ѷ���δȷ�� 4.������
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
