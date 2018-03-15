package com.goods.category.web;
/**
 * 分类的web层
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
	 * 查找所有一级二级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用servies方法
		List<Category> parents = categoryServies.findAll();
		//绑定数据
		request.setAttribute("parents", parents);
		//转发
		return "f:/jsps/left.jsp";
	}

}
