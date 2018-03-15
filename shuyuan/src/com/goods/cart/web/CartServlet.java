package com.goods.cart.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fayeloh.tools.commons.CommonUtils;
import com.fayeloh.tools.excel.JxlExcel;
import com.fayeloh.tools.servlet.BaseServlet;
import com.goods.book.entity.Book;
import com.goods.cart.entity.Cart;
import com.goods.cart.servies.CartServies;
import com.goods.user.entity.User;
/**
 * ���ﳵ��web��
 * @author lenovo
 *
 */
public class CartServlet extends BaseServlet {
	private CartServies cartServies = new CartServies();
	/**
	 * ��ӡ���
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String print(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ��session�л�ȡuid
		User user = (User) req.getSession().getAttribute("sessionUser");
		String uid = user.getUid();
		// ����Servies�����õ�����
		List<Cart> cartlist = cartServies.myCart(uid);
		Object[] title = cartServies.print();         //��ȡ���ݱ������
		Object[][] body = new Object[cartlist.size()][10];//��ȡ����е�����
		for(int i=0;i<cartlist.size();i++){
			 body[i][0] = cartlist.get(i).getCartItemId(); 
			 body[i][1] = cartlist.get(i).getQuantity()+""; //+�������ɽ��intת����String���͵Ĳ���
			 body[i][2] = cartlist.get(i).getBook().getBname(); 
			 body[i][3] = cartlist.get(i).getUser().getUid(); 
			 body[i][4] = cartlist.get(i).getCartItemId(); 
			 body[i][5] = cartlist.get(i).getCartItemId(); 
			 body[i][6] = cartlist.get(i).getQuantity()+""; 
			 body[i][7] = cartlist.get(i).getBook().getBname(); 
			 body[i][8] = cartlist.get(i).getUser().getUid(); 
			 body[i][9] = cartlist.get(i).getCartItemId(); 
		
		}
		JxlExcel.print("D:/biaoge.xls", title, body);//title:һά���飬body����ά���飬��ӡ����
		req.setAttribute("code", "success");
		req.setAttribute("msg", "��ӡ�ɹ����뵽D�̲鿴���ҵĹ��ﳵ�嵥�����");
		return "f:/jsps/msg.jsp";   //ת����msg.jsp����
		
	}
	/**
	 * ���ع��ﳵ
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loadCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cartItemIds = req.getParameter("cartItemIds");
		double total = Double.parseDouble(req.getParameter("total"));
		List<Cart> cartList = cartServies.loadCart(cartItemIds);
		req.setAttribute("cartList", cartList);
		req.setAttribute("total", total);
		System.out.println(cartList.toString());
		return "f:/jsps/cart/showitem.jsp";
	}
	/**
	 * �ҵĹ��ﳵ
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��session�л�ȡuid
		User user = (User) req.getSession().getAttribute("sessionUser");
		String uid = user.getUid();
		//����Servies�����õ�����
		List<Cart> cartlist = cartServies.myCart(uid);
		//�󶨲���
		req.setAttribute("cartlist", cartlist);
		return "f:/jsps/cart/list.jsp";
	}
	/**
	 * ���ӹ�����Ŀ����
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1.��װ������
		 */
		Map<String,Object> map = req.getParameterMap();
		Cart cart = CommonUtils.toBean(map, Cart.class);
		Book book = CommonUtils.toBean(map, Book.class);
		User user = (User) req.getSession().getAttribute("sessionUser");
		cart.setBook(book);
		cart.setUser(user);
		/**
		 * 2.����servies�ķ���
		 */
		cartServies.add(cart);
		/**
		 * 3.��ѯ���û���������Ŀ��ת��list��ʾ
		 */
		return myCart(req, resp);
	}
	/**
	 * ����ɾ��+����ɾ��
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String batchDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * ��ȡ�ɱ����
		 */
		String cartItemIds = req.getParameter("cartItemIds");
		System.out.println(cartItemIds);
		/*
		 * ����servies����
		 */
		cartServies.batchDelete(cartItemIds);
		/*
		 * ת�������ﳵ
		 */
		return myCart(req, resp);
	}
	/**
	 * ��������
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String updateQuantity(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String cartItemId = req.getParameter("cartItemId");
		Cart cart = cartServies.updateQuantity(cartItemId, quantity);
		//json��ʽ
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"quantity\"").append(":").append(cart.getQuantity());
		sb.append("\"subtotal\"").append(":").append(cart.getSubtotal());
		sb.append("}");
		//������ͻ���
		resp.getWriter().print(sb);
		return null;
	}
}
