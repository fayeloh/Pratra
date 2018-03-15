package com.fayeloh.tools.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * һ�����ж�����󷽷���ÿ��������󷽷���ԭ�͸�servies��ͬ ԭ��=����ֵ+������+�����б�
 * 
 * @author Administrator
 * 
 */
public class BaseServlet extends HttpServlet {
	/**
	 * ��дservies����
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");// ������Ӧ����
		/*
		 * ��ȡ�������ƣ����û�Ҫ���õķ��� ����������ת����method�Ķ���,���䣬�ô����������ܶ��if...elseѭ��
		 * ���÷���invoke����
		 */
		String methodName = request.getParameter("method");
		Method method = null;
		try {
			method = this.getClass().getMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("��Ҫ���õķ�����" + methodName + "������", e);
		}
		try {
			String result = (String) method.invoke(this, request, response);
			if (result != null && !result.trim().isEmpty()) {
				/*
				 * �ֽ��ַ����ָð��ǰ��r���ض���f��ת��
				 */
				int index = result.indexOf(":");// ��ȡ��һ��ð�ŵ�λ��
				if (index == -1) {// ���û�е�һ��ð�ţ�ת��
					request.getRequestDispatcher(result).forward(request,
							response);
				} else {
					String start = result.substring(0, index);
					String path = result.substring(index + 1);
					if (start.equals("f")) {
						request.getRequestDispatcher(path).forward(request,
								response);
					} else if (start.equals("r")) {
						response.sendRedirect(path);// ?request.getContextPath()��ʾ����ҳ��
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
