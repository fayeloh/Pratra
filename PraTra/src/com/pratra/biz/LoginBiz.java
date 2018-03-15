package com.pratra.biz;

import java.util.ArrayList;
import java.util.Random;

/**
 * @登陆的相关逻辑操作
 */
public class LoginBiz {
	// public String random = "";

	public LoginBiz() {
		init();
	}

	public void init() {

	}

	public String getRandom() { // 得到随机数
		String random = "";
		ArrayList<String> list = new ArrayList<String>();// 显示验证码的四位随机数
		for (int i = 0; i < 10; i++) {
			list.add(i + ""); // 产生4位随机数
		}
		Random r = new Random();// 获得随机数
		for (int x = 0; x < 4; x++) {
			String num = list.remove(r.nextInt(10 - x));
			random += num;
		}
		return random;// 返回随机数
	}
}
