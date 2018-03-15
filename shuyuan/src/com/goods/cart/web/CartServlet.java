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
 * 购物车的web层
 * @author lenovo
 *
 */
public class CartServlet extends BaseServlet {
	private CartServies cartServies = new CartServies();
	/**
	 * 打印表格
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String print(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 从session中获取uid
		User user = (User) req.getSession().getAttribute("sessionUser");
		String uid = user.getUid();
		// 调用Servies方法得到集合
		List<Cart> cartlist = cartServies.myCart(uid);
		Object[] title = cartServies.print();         //获取数据表的列名
		Object[][] body = new Object[cartlist.size()][10];//获取表格中的数据
		for(int i=0;i<cartlist.size();i++){
			 body[i][0] = cartlist.get(i).getCartItemId(); 
			 body[i][1] = cartlist.get(i).getQuantity()+""; //+“”即可解决int转化成String类型的操作
			 body[i][2] = cartlist.get(i).getBook().getBname(); 
			 body[i][3] = cartlist.get(i).getUser().getUid(); 
			 body[i][4] = cartlist.get(i).getCartItemId(); 
			 body[i][5] = cartlist.get(i).getCartItemId(); 
			 body[i][6] = cartlist.get(i).getQuantity()+""; 
			 body[i][7] = cartlist.get(i).getBook().getBname(); 
			 body[i][8] = cartlist.get(i).getUser().getUid(); 
			 body[i][9] = cartlist.get(i).getCartItemId(); 
		
		}
		JxlExcel.print("D:/biaoge.xls", title, body);//title:一维数组，body：二维数组，打印操作
		req.setAttribute("code", "success");
		req.setAttribute("msg", "打印成功，请到D盘查看‘我的购物车清单’表格");
		return "f:/jsps/msg.jsp";   //转发到msg.jsp界面
		
	}
	/**
	 * 加载购物车
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
	 * 我的购物车
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//从session中获取uid
		User user = (User) req.getSession().getAttribute("sessionUser");
		String uid = user.getUid();
		//调用Servies方法得到集合
		List<Cart> cartlist = cartServies.myCart(uid);
		//绑定参数
		req.setAttribute("cartlist", cartlist);
		return "f:/jsps/cart/list.jsp";
	}
	/**
	 * 增加购物条目功能
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1.封装表单数据
		 */
		Map<String,Object> map = req.getParameterMap();
		Cart cart = CommonUtils.toBean(map, Cart.class);
		Book book = CommonUtils.toBean(map, Book.class);
		User user = (User) req.getSession().getAttribute("sessionUser");
		cart.setBook(book);
		cart.setUser(user);
		/**
		 * 2.调用servies的方法
		 */
		cartServies.add(cart);
		/**
		 * 3.查询出用户的所有条目，转发list显示
		 */
		return myCart(req, resp);
	}
	/**
	 * 批量删除+单个删除
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String batchDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 获取可变参数
		 */
		String cartItemIds = req.getParameter("cartItemIds");
		System.out.println(cartItemIds);
		/*
		 * 调用servies方法
		 */
		cartServies.batchDelete(cartItemIds);
		/*
		 * 转发到购物车
		 */
		return myCart(req, resp);
	}
	/**
	 * 更改数量
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
		//json格式
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"quantity\"").append(":").append(cart.getQuantity());
		sb.append("\"subtotal\"").append(":").append(cart.getSubtotal());
		sb.append("}");
		//输出到客户端
		resp.getWriter().print(sb);
		return null;
	}
}
