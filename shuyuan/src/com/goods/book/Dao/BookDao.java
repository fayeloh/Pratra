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
 * 图书持久层
 * @author lenovo
 *
 */
public class BookDao {
	QueryRunner qr = new TxQueryRunner();
	/**
	 * 根据bid查询书本
	 * @param bid
	 * @return
	 * @throws SQLException 
	 */
	public Book findByBid(String bid) throws SQLException{
		String sql="select * from t_book where bid=?";
		//一行记录中包含许多book属性
		Map<String,Object> map = qr.query(sql, new MapHandler(),bid);
		//把map中出cid以外的属性映射到book中
		Book book = CommonUtils.toBean(map, Book.class);
		//把cid映射到category中
		Category category = CommonUtils.toBean(map, Category.class);
		book.setCategory(category);
		return book;
	}
	
	/**
	 * 按书名模糊查询
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
	 * 按作者模糊查询
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
	 * 按出版社模糊查询
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
	 * 按多条件查询
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
	 * 按分类查询
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
	 * 通用查询
	 * @throws SQLException 
	 */
	private PageBean<Book> findByCriteria(List<Expression> exprlist,int pc) throws SQLException{
		/*
		 * 1.取得ps
		 * 2.创建whereSql语句
		 * 3.取得总记录数tr
		 * 4，创建PageBean
		 */
		int ps=PageConstants.BOOK_PAGE_SIZE;
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
		String sql = "select count(*) from t_book"+whereSql;
		Number number = (Number) qr.query(sql,new ScalarHandler(),params.toArray());
		int tr = number.intValue();
		//得到BeanList
		sql = "select * from t_book"+whereSql+" order by orderBy limit ?,?";
		params.add((pc-1)*ps);//当前页的第一行数
		params.add(ps);//一页查询几行，就是每页记录数
		List<Book> beanList = qr.query(sql, new BeanListHandler<Book>(Book.class),params.toArray());
	    //创建PageBean
		PageBean<Book> pageBean = new PageBean<Book>();
		//增加参数
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		pageBean.setTr(tr);
		pageBean.setBeanList(beanList);
		//pageBean没有url，由servlet完成
		return pageBean;
	}
	
}
