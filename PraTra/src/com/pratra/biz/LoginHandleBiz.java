package com.pratra.biz;

public class LoginHandleBiz {

	private static final LoginHandleBiz loginhandleBiz= new LoginHandleBiz();//定义本类实例
	private LoginHandleBiz(){
		
	}
	/**
	 * 返回登陆结果处理类实例
	 * 
	 * @return
	 * */
	public static LoginHandleBiz getLoginHandleBiz() {
		return LoginHandleBiz.loginhandleBiz;
	}
	/**
	 *处理登陆结果
	 * */
	public void loginHandle(){
	
	}
}