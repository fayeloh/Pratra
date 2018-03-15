package com.pratra.dao;

import com.pratra.entity.WriUser;

/**
 * @ ���ݿ����Ӳ�Ĵ���� @ UserDAOImpl������ز���
 */

public class UserDAOProxy {

	private UserDAOImpl userDAOImpl;

	public UserDAOProxy() {
		init();
	}

	private void init() {
		userDAOImpl = new UserDAOImpl();
	}

	public WriUser insert(WriUser wriUser) {// ��������
		return userDAOImpl.insert(wriUser);
	}

	public WriUser check(String id) { // ��ѯ��������
		return userDAOImpl.check(id);
	}

}
