package com.goods.user.servies;


import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;

import com.fayeloh.tools.commons.CommonUtils;
import com.fayeloh.tools.mail.Mail;
import com.fayeloh.tools.mail.MailUtils;
import com.goods.user.dao.UserDao;
import com.goods.user.entity.User;
import com.goods.user.exception.UserException;

/*
 * 业务层
 * */
public class UserServies {
	UserDao userDao = new UserDao();
	/**
	 * 修改密码
	 * @param uid
	 * @param loginpass
	 * @param newpass
	 * @throws UserException 
	 */
	public void updatePassWord(String loginname,String loginpass,String newpass) throws UserException{
		try {
			//1.校验老密码
			boolean bool = userDao.findByPass(loginname, loginpass);
			if(!bool){
				throw new UserException("老密码不正确SERVIES");
			}
			//2.修改新密码
			userDao.updatePass(loginpass, newpass);
		} catch (SQLException e) {
			//校验失败
			throw new RuntimeException(e);
		}
	}
	/**
	 * 根据登录名和密码查找用户
	 * @param loginname
	 * @param loginpass
	 * @return 
	 */
	public User login(User user){
		try {
			return userDao.findByLoginnameAndLoginpass(user.getLoginname(),user.getLoginpass());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 激活功能
	 * @param code
	 */
	public void activation(String code){
		try {
			//1.查找用户
			User user = userDao.findByCode(code);
			//2.user为null，抛出异常，显示无效激活
			if(user==null)throw new UserException("无效激活");
			//3.不为null，当status为true、使抛出异常，显示不可二次激活
			if(user.isStatus())throw new UserException("不可二次显示");
			//4.修改用户状态为true
//		user.setStatus(true);
			userDao.updateStatus(user.getUid(), true);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * 校验用户名
	 * */
	public boolean validateLoginName(String loginname){
		try {
			return userDao.validateLoginName(loginname);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * 校验email
	 * */
	public boolean validateEmail(String email){
		try {
//			return validateEmail(email);   死递归：报java.lang.StackOverflowError异常
			return userDao.validateEmail(email);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * 增加用户
	 * */
	public void regist(User user){
		//1.数据补齐
		user.setUid(CommonUtils.uuid());
		user.setStatus(false);
		user.setActivationCode(CommonUtils.uuid()+CommonUtils.uuid());
		
		/*
		 * 2.数据库插入
		 * */
		try {
			userDao.add(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		/*
//		 * 3.发邮件
//		 * */
//		/*
//		 * 加载配置文件
//		 * */
//		Properties prop = new Properties();
//		try {
//			prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		/*
//		 * 登录邮箱服务器，得到session
//		 * */
//		String host=prop.getProperty("host");//邮箱服务器主机名
//		String username=prop.getProperty("username");//登录名
//		String password = prop.getProperty("password");//登陆密码
//		Session session = MailUtils.createSession(host, username, password);
//		/*
//		 * 创建Mail对象
//		 * */
//		String from=prop.getProperty("from");
//		String to=user.getEmail();
//		String subject=prop.getProperty("subject");
//		//处理有占位符的语句
//		String content=MessageFormat.format(prop.getProperty("content"),user.getActivationCode());
//		Mail mail = new Mail(from,to,subject,content);
//		/*
//		 * 发送邮件
//		 * */ 
//		try {
//			MailUtils.send(session, mail);
//		} catch (Exception e1) {
//			throw new RuntimeException(e1);
//		}
	}
	/**
	 * 单点登录功能，检查用户是否在线
	 * true已登陆
	 * false未登录
	 * @param username
	 * @param usernameList
	 * @return
	 */
	public boolean checkOnline(String username, List<String> usernameList) {
		boolean flag = true;           //true为已登陆，false为未登录
		if(usernameList.size()==0){ 
			flag = false;
			usernameList.add(username);//如果usernameList为空，将username添加进去
		}else{
			for(String un:usernameList){
				   if(un.equals(username)){//存在该用户名，返回true
					   flag = true;
					   return flag;
				   } 
				   flag = false;
				   usernameList.add(username);//否则不存在
			}
		}
		return flag;
	}
}
