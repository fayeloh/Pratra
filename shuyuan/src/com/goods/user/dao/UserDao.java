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
 * 持久层
 * */
public class UserDao {
	//调用自己写的jar包里的TxQueryRunner方法
	QueryRunner qr = new TxQueryRunner();
	
	/**
	 * 根据uid和登陆密码查询是否存在用户
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
	 * 修改密码
	 * @param loginpass
	 * @param newpass
	 * @throws SQLException
	 */
	public void updatePass(String loginpass,String newpass) throws SQLException{
		String sql="update t_user set loginpass=? where loginpass=?";
		try {
			newpass = EncoderByMD5.encoderBy(newpass);//用MD5加密密码
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qr.update(sql,newpass,loginpass);
	}
	/**
	 * 根据登录名和密码查找用户
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
	 * 根据激活码找用户
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
	 * 修改用户状态
	 * @param uid
	 * @param status
	 * @throws Exception
	 */
	public void updateStatus(String uid,boolean status) throws Exception{
		String sql="update t_user set uid=? and status=?";
		qr.update(sql,uid,status);
	}
	/*
	 * 校验用户名
	 * */
	public boolean validateLoginName(String loginname) throws Exception{
		String sql ="select count(1) from t_user where loginname=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(),loginname);
		return number.intValue()==0;
	}
	/*
	 * 校验email
	 * */
	public boolean validateEmail(String email) throws Exception{
		String sql ="select count(1) from t_user where email=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(),email);
		return number.intValue()==0;
	}
	/*
	 * 注册用户
	 * */
	public void add(User user) throws Exception{
		String sql = "insert into t_user values(?,?,?,?,?,?)";
		String LoginPass = EncoderByMD5.encoderBy(user.getLoginpass());
		Object[] params = {user.getUid(),user.getLoginname(),LoginPass,
				user.getEmail(),user.isStatus(),user.getActivationCode()}; //大花括号
		qr.update(sql, params);
	}
}
