package com.pratra.biz;

public class LoginHandleBiz {

	private static final LoginHandleBiz loginhandleBiz= new LoginHandleBiz();//���屾��ʵ��
	private LoginHandleBiz(){
		
	}
	/**
	 * ���ص�½���������ʵ��
	 * 
	 * @return
	 * */
	public static LoginHandleBiz getLoginHandleBiz() {
		return LoginHandleBiz.loginhandleBiz;
	}
	/**
	 *�����½���
	 * */
	public void loginHandle(){
	
	}
}