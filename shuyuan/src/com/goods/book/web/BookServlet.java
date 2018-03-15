package com.goods.book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fayeloh.tools.servlet.BaseServlet;
import com.goods.book.entity.Book;
import com.goods.book.servies.BookServies;
import com.goods.pager.PageBean;

public class BookServlet extends BaseServlet {
	BookServies bookServies = new BookServies();
	/**
	 * 获取pc
	 * @param request
	 * @return
	 */
	private int getPc(HttpServletRequest request){
		int pc=1;
		String params = request.getParameter("pc");
		if(params!=null && !params.trim().isEmpty()){
			pc = Integer.parseInt(params);
		}
		return pc;
	}
	/**
	 * 截取uri，分页导航时要用到
	 * @param request
	 * @return
	 */
	private String getUrl(HttpServletRequest request){
		String url =  request.getRequestURI()+"?"+request.getQueryString();
		//如果uri存在pc参数截取掉
		int index = url.lastIndexOf("&pc");
		if(index!=-1){
			url.substring(0, index);
		}
		return url;
	}
	/**
	 * 按分类查询书
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc，如果页面存在pc，使用页面，如果没有就pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.获取查询条件，本方法就是cid，就是本类的id
		 */
		String cid = request.getParameter("cid");
		/* 4.调用servies#findByCategory获取PageBean
		 */
		PageBean<Book> pb = bookServies.findByCategory(cid, pc);
		/* 5.给pageBean设定url，转发到/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取bid
		String bid=request.getParameter("bid");
		//调用servies的load方法
		Book book = bookServies.load(bid);
		//转发
		request.setAttribute("book", book);
		return "f:/jsps/book/desc.jsp";
	}
	/**
	 * 按书名查询书
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByBname(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc，如果页面存在pc，使用页面，如果没有就pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.获取查询条件，本方法就是cid，就是本类的id
		 */
		String bname = request.getParameter("bname");
		/* 4.调用servies#findByCategory获取PageBean
		 */
		PageBean<Book> pb = bookServies.findByBname(bname, pc);
		 /* 5.给pageBean设定url，转发到/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	/**
	 * 按作者查询书
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByAuthor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc，如果页面存在pc，使用页面，如果没有就pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.获取查询条件，本方法就是cid，就是本类的id
		 */
		String author = request.getParameter("author");
		/* 4.调用servies#findByCategory获取PageBean
		 */
		PageBean<Book> pb = bookServies.findByAuthor(author, pc);
		 /* 5.给pageBean设定url，转发到/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		System.out.println(author);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	/**
	 * 按出版社查询书
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByPress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc，如果页面存在pc，使用页面，如果没有就pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.获取查询条件，本方法就是cid，就是本类的id
		 */
		String press = request.getParameter("press");
		System.out.println(press);
		/* 4.调用servies#findByCategory获取PageBean
		 */
		PageBean<Book> pb = bookServies.findByPress(press, pc);
		 /* 5.给pageBean设定url，转发到/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	/**
	 * 多条件组合查询书
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByCriteria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc，如果页面存在pc，使用页面，如果没有就pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.获取查询条件，本方法就是cid，就是本类的id
		 */
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		/* 4.调用servies#findByCategory获取PageBean
		 */
		Book criteria = new Book();
		criteria.setBname(bname);
		criteria.setAuthor(author);
		criteria.setPress(press);
		PageBean<Book> pb= bookServies.findByCombination(criteria, pc);
		 /* 5.给pageBean设定url，转发到/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
}
