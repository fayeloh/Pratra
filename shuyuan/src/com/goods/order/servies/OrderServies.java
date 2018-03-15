package com.goods.order.servies;

import com.fayeloh.tools.jdbc.JdbcUtils;
import com.goods.order.dao.OrderDao;
import com.goods.order.entiry.Order;
import com.goods.pager.PageBean;

/**
 * ������ҵ���
 * @author lenovo
 *
 */
public class OrderServies {
	private OrderDao orderDao = new OrderDao();
	/**
	 * �ҵĶ���
	 * @param uid
	 * @param pc
	 * @return
	 */
	public PageBean<Order> myOrder(String uid,int pc){
		try {
			JdbcUtils.beginTransaction();
			PageBean<Order> pb = orderDao.findByUser(uid, pc);
			JdbcUtils.commitTransaction();
			return pb;
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (Exception e1) {
			}
			throw new RuntimeException(e);//�׳��쳣λ�ò�ͬ������
		}
	}
}
