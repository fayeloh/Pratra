package com.pratra.dao;

import com.pratra.entity.WriUser;

/**
 * @ 数据库连接层的代理层 @ UserDAOImpl传递相关操作
 */

public class UserDAOProxy {

	private UserDAOImpl userDAOImpl;

	public UserDAOProxy() {
		init();
	}

	private void init() {
		userDAOImpl = new UserDAOImpl();
	}

	public WriUser insert(WriUser wriUser) {// 增加数据
		return userDAOImpl.insert(wriUser);
	}

	public WriUser check(String id) { // 查询单行数据
		return userDAOImpl.check(id);
	}

}
