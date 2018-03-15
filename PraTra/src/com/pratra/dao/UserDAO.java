package com.pratra.dao;

import com.pratra.entity.WriUser;

/**
 * @数据库连接层
 **/

public abstract class UserDAO {

	// 添加用户
	abstract WriUser insert(WriUser wriUser);

	// 查找用户 打印
	abstract Object[][] query();

	// 单个查找
	abstract WriUser check(String id);

	// 修改用户
	abstract void delete(String id);
}
