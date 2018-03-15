package com.pratra.dao;

import com.pratra.entity.WriUser;

/**
 * @���ݿ����Ӳ�
 **/

public abstract class UserDAO {

	// ����û�
	abstract WriUser insert(WriUser wriUser);

	// �����û� ��ӡ
	abstract Object[][] query();

	// ��������
	abstract WriUser check(String id);

	// �޸��û�
	abstract void delete(String id);
}
