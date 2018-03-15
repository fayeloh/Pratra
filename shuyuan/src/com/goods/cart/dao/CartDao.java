package com.goods.cart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.fayeloh.tools.commons.CommonUtils;
import com.fayeloh.tools.jdbc.TxQueryRunner;
import com.goods.book.entity.Book;
import com.goods.cart.entity.Cart;
import com.goods.user.entity.User;

/**
 * ���ﳵ�ĳ־ò�
 * 
 * @author lenovo
 * 
 */
public class CartDao {
	private QueryRunner qr = new TxQueryRunner();
	/**
	 * ��ӡ���
	 * @return
	 * @throws SQLException
	 */
	public Object[] print() throws SQLException{
		String titleName = "t_cartitem";
		//��ѯ�����ݱ������
		String sql = "select column_name from information_schema.COLUMNS where table_name=?";
		
		List<Object> titleList = qr.query(sql,new ColumnListHandler(),titleName);
		Object[] title = new Object[titleList.size()];
		//��titleList����ת����һά����
		for(int i=0;i<titleList.size();i++){
			title[i]=  titleList.get(i);
		}
		return title;
	}
	/**
	 * �����cart�ֿ�
	 * 
	 * @param map
	 * @return
	 */
	private Cart toCart(Map<String, Object> map) {
		if (map == null || map.size() == 0)
			return null;
		Cart cart = CommonUtils.toBean(map, Cart.class);
		Book book = CommonUtils.toBean(map, Book.class);
		User user = CommonUtils.toBean(map, User.class);
		cart.setBook(book);
		cart.setUser(user);
		return cart;

	}

	/**
	 * �����mapӳ��ɶ��cart
	 * 
	 * @param maplist
	 * @return
	 */
	private List<Cart> toCartList(List<Map<String, Object>> maplist) {
		List<Cart> cartList = new ArrayList<Cart>();
		for (Map<String, Object> map : maplist) {
			Cart cart = toCart(map);
			cartList.add(cart);
		}
		return cartList;
	}
	/**
	 * ����whereSql���
	 * @param len
	 * @return
	 */
	private String toWhereSql(int len){
		StringBuilder whereSql = new StringBuilder("cartItemId in(");
		for(int i=0;i<len;i++){
			whereSql.append("?");
			if(i<len-1){
				whereSql.append(",");
			}
		}
		whereSql.append(")");
		//��StringBulilderת����String
		return whereSql.toString();
	}
	/**
	 * ��ѯ���ﳵ��Ŀ
	 * @param cartItemIds
	 * @return
	 * @throws SQLException
	 */
	public List<Cart> loadCart(String cartItemIds) throws SQLException{
		Object[] cartList = cartItemIds.split(",");
		String whereSql =toWhereSql(cartList.length);
		String sql = "select * from t_cartitem c,t_book b where c.bid=b.bid and "+whereSql;
		List<Map<String,Object>> map= qr.query(sql, new MapListHandler(),cartList);
		return toCartList(map);
	}
	/**
	 * ����cartId���ҹ��ﳵ
	 * @param cartId
	 * @return
	 * @throws SQLException
	 */
	public Cart findByCartItemId(String cartItemId) throws SQLException{
		String sql="select * from t_cartitem c,t_book b where t.bid=b.bid and c.cartItemId = ?";
		Map<String,Object> map= qr.query(sql, new MapHandler(),cartItemId);
		Cart cart = toCart(map);
		return cart;
	}
	/**
	 * ����ɾ����Ҳ�����ڵ���ɾ��
	 * @param cartItemIds
	 * @throws SQLException
	 */
	public void batchDelete(String cartItemIds) throws SQLException{
		/*
		 * ����ɱ�����
		 * ���ַ���cartIds�ָ�õ�id������
		 * ��ת����whereSql���
		 * ��whereSql�����delete from t_cartitem where ����
		 */
		Object[] ids = cartItemIds.split(",");
		String whereSql = toWhereSql(ids.length);
		String sql = "delete from t_cartitem where "+whereSql;
		qr.update(sql,ids);//�ǵð�����ids�ӽ�ȥŶ
		
	}
	/**
	 * ͨ���û���ѯ���ﳵ
	 * 
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public List<Cart> findByUser(String uid) throws SQLException {
		String sql = "select * from t_cartitem c,t_book b where c.bid=b.bid and uid=? order by c.orderBy";
		List<Map<String, Object>> map = qr
				.query(sql, new MapListHandler(), uid);
		return toCartList(map);
	}

	/**
	 * ����uid��bid���ҹ��ﳵ
	 * 
	 * @param uid
	 * @param bid
	 * @return
	 * @throws SQLException
	 */
	public Cart finByUidAndBid(String uid, String bid) throws SQLException {
		String sql = "select * from t_cartitem where uid=? and bid=?";
		Cart cart = qr.query(sql, new BeanHandler<Cart>(Cart.class), uid, bid);
		return cart;
	}

	/**
	 * �����û����ﳵ���鱾����
	 * 
	 * @param quantity
	 * @param uid
	 * @throws SQLException
	 */
	public void updateQuantity(String cartItemId, int quantity)
			throws SQLException {
		String sql = "update t_cartitem set quantity=? where cartItemId=?";
		qr.update(sql, quantity, cartItemId);
	}

	/**
	 * �ڹ��ﳵ�������¼������
	 * 
	 * @param cart
	 * @throws SQLException
	 */
	public void addCartItem(Cart cart) throws SQLException {
		String sql = "insert into t_cartitem(cartItemId,quantity,bid,uid) value (?,?,?,?)";
		Object[] params = { cart.getCartItemId() , cart.getQuantity(),
			    cart.getBook().getBid() , cart.getUser().getUid() };
		qr.update(sql, params);
	}
}
