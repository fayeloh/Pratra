package com.pratra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pratra.entity.WriUser;
import com.pratra.util.DBUtil;

/**
 * @ ���ݿ����Ӳ�
 * 
 * @�����ݿ������ɾ��Ĳ���
 * @Լ��:javaBean���������Լ�����Ҫ�����ݿ��е�����һ��.
 * @listת��Ϊ��ά������߼�
 */

public class UserDAOImpl extends UserDAO {

	WriUser wriUser = new WriUser();
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement stat = null;

	@Override
	WriUser insert(WriUser wriUser) { // ���Ӳ���

		try {
			conn = DBUtil.getConnection();
			String sql = "insert into tb_write (id,state,place,no,name," + "kind,stara,inspa,diar,"
					+ "rent,cono,cost,cofi,phone)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, wriUser.getId());
			stat.setString(2, wriUser.getState());
			stat.setString(3, wriUser.getPlace());
			stat.setString(4, wriUser.getNo());
			stat.setString(5, wriUser.getName());
			stat.setString(6, wriUser.getKind());
			stat.setString(7, wriUser.getStrar());
			stat.setString(8, wriUser.getInspa());
			stat.setString(9, wriUser.getDiar());
			stat.setString(10, wriUser.getRent());
			stat.setString(11, wriUser.getCono());
			stat.setString(12, wriUser.getCost());
			stat.setString(13, wriUser.getCofi());
			stat.setString(14, wriUser.getPhone());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, stat, rs);
		}

		return wriUser;
	}

	public Object[][] query() { // ��ӡ��ѯ����
		Object[][] arr = null;
		WriUser wriUser = null;
		List<WriUser> list = new ArrayList<WriUser>();
		// state,place,no,name,kind,strar,inspa,diar,rent,cini,cost,cofi,phone
		try {
			String sql = "select * from tb_write";
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				wriUser = new WriUser();

				wriUser.setId(rs.getString("id").trim());
				wriUser.setState(rs.getString("state").trim());
				wriUser.setPlace(rs.getString("place").trim());
				wriUser.setNo(rs.getString("no").trim());
				wriUser.setName(rs.getString("name").trim());

				wriUser.setKind(rs.getString("kind").trim());
				wriUser.setStrar(rs.getString("stara").trim());
				wriUser.setInspa(rs.getString("inspa").trim());
				wriUser.setDiar(rs.getString("diar").trim());

				wriUser.setRent(rs.getString("rent").trim());
				wriUser.setCono(rs.getString("cono").trim());
				wriUser.setCost(rs.getString("cost").trim());
				wriUser.setCofi(rs.getString("cofi").trim());

				wriUser.setPhone(rs.getString("phone").trim());
				list.add(wriUser);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, st, rs);
		}

		// // ������ư�
		// arr = toArray(arr, wriUser, list);

		// ��ͨ��
		arr = toArrayNormal(arr, list);

		return arr;
	}

	private Object[][] toArrayNormal(Object[][] arr, List<WriUser> list) { // ��listת���ɶ�ά����
		int rows = list.size();
		if (rows != 0) {
			arr = new Object[rows][];
		}

		for (int i = 0; i < rows; i++) {
			Object[] temp = { list.get(i).getId(), list.get(i).getState(), list.get(i).getPlace(), list.get(i).getNo(),
					list.get(i).getName(), list.get(i).getKind(), list.get(i).getStrar(), list.get(i).getInspa(),
					list.get(i).getDiar(), list.get(i).getRent(), list.get(i).getCono(), list.get(i).getCost(),
					list.get(i).getCofi(), list.get(i).getPhone(), };
			arr[i] = temp;
		}
		return arr;
	}

	public WriUser check(String id) { // �������Ҳ���

		// state,place,no,name,kind,strar,inspa,diar,rent,cini,cost,cofi,phone
		try {
			String sql = "select * from tb_write where id = " + id;
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				wriUser.setState(rs.getString("state").trim());
				wriUser.setPlace(rs.getString("place").trim());
				wriUser.setNo(rs.getString("no").trim());
				wriUser.setName(rs.getString("name").trim());

				wriUser.setKind(rs.getString("kind").trim());
				wriUser.setStrar(rs.getString("stara").trim());
				wriUser.setInspa(rs.getString("inspa").trim());
				wriUser.setDiar(rs.getString("diar").trim());

				wriUser.setRent(rs.getString("rent").trim());
				wriUser.setCono(rs.getString("cono").trim());
				wriUser.setCost(rs.getString("cost").trim());
				wriUser.setCofi(rs.getString("cofi").trim());

				wriUser.setPhone(rs.getString("phone").trim());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, st, rs);
		}
		return wriUser;
	}

	public void delete(String id) { // ɾ������
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			conn = DBUtil.getConnection();
			st = conn.createStatement();
			String sql = "delete from tb_write where id=" + id;
			int i = st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, st, rs);
		}
	}

}
