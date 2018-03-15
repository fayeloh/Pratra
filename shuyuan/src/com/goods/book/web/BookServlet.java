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
	 * ��ȡpc
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
	 * ��ȡuri����ҳ����ʱҪ�õ�
	 * @param request
	 * @return
	 */
	private String getUrl(HttpServletRequest request){
		String url =  request.getRequestURI()+"?"+request.getQueryString();
		//���uri����pc������ȡ��
		int index = url.lastIndexOf("&pc");
		if(index!=-1){
			url.substring(0, index);
		}
		return url;
	}
	/**
	 * �������ѯ��
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc�����ҳ�����pc��ʹ��ҳ�棬���û�о�pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.��ȡ��ѯ����������������cid�����Ǳ����id
		 */
		String cid = request.getParameter("cid");
		/* 4.����servies#findByCategory��ȡPageBean
		 */
		PageBean<Book> pb = bookServies.findByCategory(cid, pc);
		/* 5.��pageBean�趨url��ת����/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡbid
		String bid=request.getParameter("bid");
		//����servies��load����
		Book book = bookServies.load(bid);
		//ת��
		request.setAttribute("book", book);
		return "f:/jsps/book/desc.jsp";
	}
	/**
	 * ��������ѯ��
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByBname(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc�����ҳ�����pc��ʹ��ҳ�棬���û�о�pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.��ȡ��ѯ����������������cid�����Ǳ����id
		 */
		String bname = request.getParameter("bname");
		/* 4.����servies#findByCategory��ȡPageBean
		 */
		PageBean<Book> pb = bookServies.findByBname(bname, pc);
		 /* 5.��pageBean�趨url��ת����/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	/**
	 * �����߲�ѯ��
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByAuthor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc�����ҳ�����pc��ʹ��ҳ�棬���û�о�pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.��ȡ��ѯ����������������cid�����Ǳ����id
		 */
		String author = request.getParameter("author");
		/* 4.����servies#findByCategory��ȡPageBean
		 */
		PageBean<Book> pb = bookServies.findByAuthor(author, pc);
		 /* 5.��pageBean�趨url��ת����/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		System.out.println(author);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	/**
	 * ���������ѯ��
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByPress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc�����ҳ�����pc��ʹ��ҳ�棬���û�о�pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.��ȡ��ѯ����������������cid�����Ǳ����id
		 */
		String press = request.getParameter("press");
		System.out.println(press);
		/* 4.����servies#findByCategory��ȡPageBean
		 */
		PageBean<Book> pb = bookServies.findByPress(press, pc);
		 /* 5.��pageBean�趨url��ת����/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	/**
	 * ��������ϲ�ѯ��
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByCriteria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc�����ҳ�����pc��ʹ��ҳ�棬���û�о�pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/* 3.��ȡ��ѯ����������������cid�����Ǳ����id
		 */
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		/* 4.����servies#findByCategory��ȡPageBean
		 */
		Book criteria = new Book();
		criteria.setBname(bname);
		criteria.setAuthor(author);
		criteria.setPress(press);
		PageBean<Book> pb= bookServies.findByCombination(criteria, pc);
		 /* 5.��pageBean�趨url��ת����/japs/book/list.jsp
		 */
//		PageBean<Book> pb = new PageBean<Book>();
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
}
