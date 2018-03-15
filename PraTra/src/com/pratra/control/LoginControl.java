package com.pratra.control;

import com.pratra.biz.LoginBiz;

/**
 * @ 登录的控制层
 * 
 * @mvc三层架构中的control层
 */
public class LoginControl {
	public LoginBiz loginBiz = new LoginBiz();

	public LoginControl() {
	}

	public String run() {
		return loginBiz.getRandom();
	}

}
