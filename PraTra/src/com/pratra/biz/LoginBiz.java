package com.pratra.biz;

import java.util.ArrayList;
import java.util.Random;

/**
 * @��½������߼�����
 */
public class LoginBiz {
	// public String random = "";

	public LoginBiz() {
		init();
	}

	public void init() {

	}

	public String getRandom() { // �õ������
		String random = "";
		ArrayList<String> list = new ArrayList<String>();// ��ʾ��֤�����λ�����
		for (int i = 0; i < 10; i++) {
			list.add(i + ""); // ����4λ�����
		}
		Random r = new Random();// ��������
		for (int x = 0; x < 4; x++) {
			String num = list.remove(r.nextInt(10 - x));
			random += num;
		}
		return random;// ���������
	}
}
