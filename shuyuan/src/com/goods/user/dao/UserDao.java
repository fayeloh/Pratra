package com.goods.user.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import org.junit.runner.Result;

import sun.security.provider.MD5;

import com.fayeloh.tools.jdbc.TxQueryRunner;
import com.fayeloh.tools.md5.EncoderByMD5;
import com.goods.user.entity.User;

/*
 * �־ò�
 * */
public class UserDao {
	//�����Լ�д��jar�����TxQueryRunner����
	QueryRunner qr = new TxQueryRunner();
	
	/**
	 * ����uid�͵�½�����ѯ�Ƿ�����û�
	 * @param uid
	 * @param longinpass
	 * @return
	 * @throws SQLException
	 */
	public boolean findByPass(String loginname,String loginpass) throws SQLException{
		String sql="select count(1) from t_user where loginname=? and loginpass=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(),loginname,loginpass);
		return number.intValue()>0;
	}
	/**
	 * �޸�����
	 * @param loginpass
	 * @param newpass
	 * @throws SQLException
	 */
	public void updatePass(String loginpass,String newpass) throws SQLException{
		String sql="update t_user set loginpass=? where loginpass=?";
		try {
			newpass = EncoderByMD5.encoderBy(newpass);//��MD5��������
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qr.update(sql,newpass,loginpass);
	}
	/**
	 * ���ݵ�¼������������û�
	 * @param loginname
	 * @param loginpass
	 * @return
	 * @throws SQLException 
	 */
	public User findByLoginnameAndLoginpass(String loginname,String loginpass) throws SQLException{
		String sql="select * from t_user where loginname=? and loginpass=?";
		return qr.query(sql, new BeanHandler<User>(User.class),loginname,loginpass);
	}
	/**
	 * ���ݼ��������û�
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public User findByCode(String code) throws Exception{
		String sql="select * from t_user where activation=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class),code);
		return user;
	}
	/**
	 * �޸��û�״̬
	 * @param uid
	 * @param status
	 * @throws Exception
	 */
	public void updateStatus(String uid,boolean status) throws Exception{
		String sql="update t_user set uid=? and status=?";
		qr.update(sql,uid,status);
	}
	/*
	 * У���û���
	 * */
	public boolean validateLoginName(String loginname) throws Exception{
		String sql ="select count(1) from t_user where loginname=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(),loginname);
		return number.intValue()==0;
	}
	/*
	 * У��email
	 * */
	public boolean validateEmail(String email) throws Exception{
		String sql ="select count(1) from t_user where email=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(),email);
		return number.intValue()==0;
	}
	/*
	 * ע���û�
	 * */
	public void add(User user) throws Exception{
		String sql = "insert into t_user values(?,?,?,?,?,?)";
		String LoginPass = EncoderByMD5.encoderBy(user.getLoginpass());
		Object[] params = {user.getUid(),user.getLoginname(),LoginPass,
				user.getEmail(),user.isStatus(),user.getActivationCode()}; //������
		qr.update(sql, params);
	}
}
