package com.pratra.control;

import com.pratra.biz.LoginBiz;

/**
 * @ ��¼�Ŀ��Ʋ�
 * 
 * @mvc����ܹ��е�control��
 */
public class LoginControl {
	public LoginBiz loginBiz = new LoginBiz();

	public LoginControl() {
	}

	public String run() {
		return loginBiz.getRandom();
	}

}
