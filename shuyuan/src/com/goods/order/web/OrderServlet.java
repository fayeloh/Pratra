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
 * ������web��
 * @author lenovo
 *
 */
public class OrderServlet extends BaseServlet {
	private OrderServies orderServies = new OrderServies();
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
	 * ��ѯ�ҵĶ���
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.pc�����ҳ�����pc��ʹ��ҳ�棬���û�о�pc=1
		 */
		int pc = getPc(request);
		/* 2.url
		 */
		String url = getUrl(request);
		/*
		 * 3.��session�л�ȡ
		 */
		User user = (User) request.getSession().getAttribute("sessionUser");
		/*
		 * 4.����servies#findByCategory��ȡPageBean
		 */
		PageBean<Order> pb = orderServies.myOrder(user.getUid(), pc);
		/*
		 * 5.��pageBean�趨url��ת����/japs/order/list.jsp
		 */
		pb.setUrl(url);
		request.setAttribute("pb", pb);
		return "f:/jsps/order/list.jsp";
	}
	
}
