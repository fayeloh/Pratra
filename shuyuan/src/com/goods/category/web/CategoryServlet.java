package com.goods.category.web;
/**
 * �����web��
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fayeloh.tools.servlet.BaseServlet;
import com.goods.category.entity.Category;
import com.goods.category.servies.CategoryServies;

public class CategoryServlet extends BaseServlet {
	CategoryServies categoryServies = new CategoryServies();
	/**
	 * ��������һ����������
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����servies����
		List<Category> parents = categoryServies.findAll();
		//������
		request.setAttribute("parents", parents);
		//ת��
		return "f:/jsps/left.jsp";
	}

}
