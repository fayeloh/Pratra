package com.goods.book.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fayeloh.tools.commons.CommonUtils;
import com.fayeloh.tools.jdbc.TxQueryRunner;
import com.goods.book.entity.Book;
import com.goods.category.entity.Category;
import com.goods.pager.Expression;
import com.goods.pager.PageBean;
import com.goods.pager.PageConstants;

/**
 * ͼ��־ò�
 * @author lenovo
 *
 */
public class BookDao {
	QueryRunner qr = new TxQueryRunner();
	/**
	 * ����bid��ѯ�鱾
	 * @param bid
	 * @return
	 * @throws SQLException 
	 */
	public Book findByBid(String bid) throws SQLException{
		String sql="select * from t_book where bid=?";
		//һ�м�¼�а������book����
		Map<String,Object> map = qr.query(sql, new MapHandler(),bid);
		//��map�г�cid���������ӳ�䵽book��
		Book book = CommonUtils.toBean(map, Book.class);
		//��cidӳ�䵽category��
		Category category = CommonUtils.toBean(map, Category.class);
		book.setCategory(category);
		return book;
	}
	
	/**
	 * ������ģ����ѯ
	 * @param cid
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByBname(String bname,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("bname","like","%"+bname+"%"));
		return findByCriteria(exprList, pc);
	}
	/**
	 * ������ģ����ѯ
	 * @param cid
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByAuthor(String author,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("author","like","%"+author+"%"));
		return findByCriteria(exprList, pc);
	}
	/**
	 * ��������ģ����ѯ
	 * @param cid
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByPress(String press,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("press","like","%"+press+"%"));
		return findByCriteria(exprList, pc);
	}
	/**
	 * ����������ѯ
	 * @param cid 
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByCombination(Book criteria,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("bname","like","%"+criteria.getBname()+"%"));
		exprList.add(new Expression("author","like","%"+criteria.getAuthor()+"%"));
		exprList.add(new Expression("press","like","%"+criteria.getPress()+"%"));
		System.out.println(exprList);
		return findByCriteria(exprList, pc);
	}
//	select * from t_book where bname like %java%;
	/**
	 * �������ѯ
	 * @param cid
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByCategory(String cid,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("cid","=",cid));
		return findByCriteria(exprList, pc);
	}
	/**
	 * ͨ�ò�ѯ
	 * @throws SQLException 
	 */
	private PageBean<Book> findByCriteria(List<Expression> exprlist,int pc) throws SQLException{
		/*
		 * 1.ȡ��ps
		 * 2.����whereSql���
		 * 3.ȡ���ܼ�¼��tr
		 * 4������PageBean
		 */
		int ps=PageConstants.BOOK_PAGE_SIZE;
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
		String sql = "select count(*) from t_book"+whereSql;
		Number number = (Number) qr.query(sql,new ScalarHandler(),params.toArray());
		int tr = number.intValue();
		//�õ�BeanList
		sql = "select * from t_book"+whereSql+" order by orderBy limit ?,?";
		params.add((pc-1)*ps);//��ǰҳ�ĵ�һ����
		params.add(ps);//һҳ��ѯ���У�����ÿҳ��¼��
		List<Book> beanList = qr.query(sql, new BeanListHandler<Book>(Book.class),params.toArray());
	    //����PageBean
		PageBean<Book> pageBean = new PageBean<Book>();
		//���Ӳ���
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		pageBean.setTr(tr);
		pageBean.setBeanList(beanList);
		//pageBeanû��url����servlet���
		return pageBean;
	}
	
}
