package com.goods.book.servies;

import java.sql.SQLException;

import com.goods.book.Dao.BookDao;
import com.goods.book.entity.Book;
import com.goods.pager.PageBean;

/**
 * 图书业务层
 * @author lenovo
 *
 */
public class BookServies {
	BookDao bookDao = new BookDao();
	/**
	 * 通过bid查询书籍
	 * @param bid
	 * @return
	 */
	public Book load(String bid){
		try {
			return bookDao.findByBid(bid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 按分类查询
	 * @param cid
	 * @param pc
	 * @return
	 */
	public PageBean<Book> findByCategory(String cid,int pc){
		try {
			return bookDao.findByCategory(cid, pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 按书名查询
	 * @param cid
	 * @param pc
	 * @return
	 */
	public PageBean<Book> findByBname(String bname,int pc){
		try {
			return bookDao.findByBname(bname, pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 按作者查询
	 * @param cid
	 * @param pc
	 * @return
	 */
	public PageBean<Book> findByAuthor(String author,int pc){
		try {
			return bookDao.findByAuthor(author, pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 按出版社查询
	 * @param cid
	 * @param pc
	 * @return
	 */
	public PageBean<Book> findByPress(String press,int pc){
		try {
			return bookDao.findByPress(press, pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 按多条件查询
	 * @param cid
	 * @param pc
	 * @return
	 */
	public PageBean<Book> findByCombination(Book criteria,int pc){
		try {
			return bookDao.findByCombination(criteria, pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
