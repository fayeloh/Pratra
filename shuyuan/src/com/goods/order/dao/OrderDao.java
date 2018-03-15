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
 * 订单的持久层
 * @author lenovo
 *
 */
public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();
	/**
	 * 根据用户查询订单
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
	 * 通用查询
	 * @throws SQLException 
	 */
	private PageBean<Order> findByCriteria(List<Expression> exprlist,int pc) throws SQLException{
		/*
		 * 1.取得ps
		 * 2.创建whereSql语句
		 * 3.取得总记录数tr
		 * 4，创建PageBean
		 */
		int ps=PageConstants.ORDER_PAGE_SIZE;
		StringBuilder whereSql = new StringBuilder(" where 1=1");//记得空格
		List<Object> params = new ArrayList<Object>();//对应Sql语句问号的值 
		/*
		 * 1.以and开头
		 * 2.增加参数
		 * 3.判断运算符是否为is null
		 * 4.不是is null加问号，在params中增加值
		 */
		for(Expression expr:exprlist){
			whereSql.append(" and ").append(expr.getName())
			.append(" ").append(expr.getOperator()).append("");
			//如果oparetion不是is null的话，增加value
			if(!expr.getOperator().equals("is null")){
				whereSql.append("?");
				params.add(expr.getValue());
			}
		}
		//得到总记录数
		String sql = "select count(*) from t_order"+whereSql;
		Number number = (Number) qr.query(sql,new ScalarHandler(),params.toArray());
		int tr = number.intValue();
		//得到BeanList
		sql = "select * from t_order"+whereSql+" order by ordertime desc limit ?,?";
		params.add((pc-1)*ps);//当前页的第一行数
		params.add(ps);//一页查询几行，就是每页记录数
		List<Order> beanList = qr.query(sql, new BeanListHandler<Order>(Order.class),params.toArray());
	   //循环遍历order,加载order内的所有条目
		for(Order order:beanList){
			List<OrderItem> orderItemList = loadOrderItem(order);
			order.setOrderItemList(orderItemList);
		}
		//创建PageBean
		PageBean<Order> pageBean = new PageBean<Order>();
		//增加参数
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		pageBean.setTr(tr);
		pageBean.setBeanList(beanList);
		//pageBean没有url，由servlet完成
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
