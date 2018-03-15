package com.goods.order.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fayeloh.tools.servlet.BaseServlet;
import com.goods.order.entiry.Order;
import com.goods.order.servies.OrderServies;
import com.goods.pager.PageBean;
import com.goods.user.entity.User;
/**
 * 订单的web层
 * @author lenovo
 *
 */
public class OrderServlet extends BaseServlet {
	private OrderServies orderServies = new OrderServies();
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
	 * 查询我的订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc，如果页面存在pc，使用页面，如果没有就pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/*
		 * 3.从session中获取
		 */
		User user = (User) request.getSession().getAttribute("sessionUser");
		/*
		 * 4.调用servies#findByCategory获取PageBean
		 */
		PageBean<Order> pb = orderServies.myOrder(user.getUid(), pc);
		/*
		 * 5.给pageBean设定url，转发到/japs/order/list.jsp
		 */
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/order/list.jsp";
	}
	
}
