package com.fayeloh.tools.filter;

/**
 * װ����ģʽ
 */
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * ȫջ���������
 * װ����ģʽ
 * @author lenovo
 *
 */
public class CharSetRequest extends HttpServletRequestWrapper {

	public CharSetRequest(HttpServletRequest request) {
		super(request);//���ø��๹�췽���������ഫ�ݵײ����
	}
	/*
	 * ��ǿgetparameter����
	 */
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);   //��super����Ϊ�ǵ��ø���ķ����õ�ֵ
		if(getMethod().equalsIgnoreCase("GET")){
		try {
				value=new String(value.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		}
		return value;  //���ر�����ֵ
	}
}
