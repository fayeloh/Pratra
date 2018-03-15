package com.goods.order.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fayeloh.tools.commons.CommonUtils;
import com.fayeloh.tools.jdbc.TxQueryRunner;
import com.goods.book.entity.Book;
import com.goods.order.entiry.Order;
import com.goods.order.entiry.OrderItem;
import com.goods.pager.Expression;
import com.goods.pager.PageBean;
import com.goods.pager.PageConstants;

/**
 * �����ĳ־ò�
 * @author lenovo
 *
 */
public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();
	/**
	 * �����û���ѯ����
	 * @param uid
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Order> findByUser(String uid,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("uid","=",uid));
		return findByCriteria(exprList, pc);
	}
	/**
	 * ͨ�ò�ѯ
	 * @throws SQLException 
	 */
	private PageBean<Order> findByCriteria(List<Expression> exprlist,int pc) throws SQLException{
		/*
		 * 1.ȡ��ps
		 * 2.����whereSql���
		 * 3.ȡ���ܼ�¼��tr
		 * 4������PageBean
		 */
		int ps=PageConstants.ORDER_PAGE_SIZE;
		StringBuilder whereSql = new StringBuilder(" where 1=1");//�ǵÿո�
		List<Object> params = new ArrayList<Object>();//��ӦSql����ʺŵ�ֵ 
		/*
		 * 1.��and��ͷ
		 * 2.���Ӳ���
		 * 3.�ж�������Ƿ�Ϊis null
		 * 4.����is null���ʺţ���params������ֵ
		 */
		for(Expression expr:exprlist){
			whereSql.append(" and ").append(expr.getName())
			.append(" ").append(expr.getOperator()).append("");
			//���oparetion����is null�Ļ�������value
			if(!expr.getOperator().equals("is null")){
				whereSql.append("?");
				params.add(expr.getValue());
			}
		}
		//�õ��ܼ�¼��
		String sql = "select count(*) from t_order"+whereSql;
		Number number = (Number) qr.query(sql,new ScalarHandler(),params.toArray());
		int tr = number.intValue();
		//�õ�BeanList
		sql = "select * from t_order"+whereSql+" order by ordertime desc limit ?,?";
		params.add((pc-1)*ps);//��ǰҳ�ĵ�һ����
		params.add(ps);//һҳ��ѯ���У�����ÿҳ��¼��
		List<Order> beanList = qr.query(sql, new BeanListHandler<Order>(Order.class),params.toArray());
	   //ѭ������order,����order�ڵ�������Ŀ
		for(Order order:beanList){
			List<OrderItem> orderItemList = loadOrderItem(order);
			order.setOrderItemList(orderItemList);
		}
		//����PageBean
		PageBean<Order> pageBean = new PageBean<Order>();
		//���Ӳ���
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		pageBean.setTr(tr);
		pageBean.setBeanList(beanList);
		//pageBeanû��url����servlet���
		return pageBean;
	}
	
private List<OrderItem> loadOrderItem(Order order) throws SQLException{
	    String sql="select * from t_orderitem where oid = ?";
	    List<Map<String,Object>> mapList = qr.query(sql, new MapListHandler(),order.getOid());
	    List<OrderItem> orderItemList = toOrderList(mapList);
		return orderItemList;
	}
private List<OrderItem> toOrderList(List<Map<String, Object>> mapList) {
	List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	for(Map<String,Object> map:mapList){
		OrderItem orderItem = toOrderItem(map);
		orderItemList.add(orderItem);
		
	}
	return orderItemList;
}
private OrderItem toOrderItem(Map<String, Object> map) {
		OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		orderItem.setBook(book);
		return orderItem;
}

}
