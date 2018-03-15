package com.fayeloh.tools.vcode.servlet;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fayeloh.tools.vcode.utils.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			VerifyCode vc = new VerifyCode();
			BufferedImage img = vc.getImage();//��ȡһ����ͼƬ��֤��
			System.out.println(vc.getText());
			vc.save(img, response.getOutputStream());
			request.getSession().setAttribute("vCode", vc.getText());// ���ı����浽session�У�ΪLoginServlet��֤��׼��
	}
}
