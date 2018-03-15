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
 * ҵ���
 * */
public class UserServies {
	UserDao userDao = new UserDao();
	/**
	 * �޸�����
	 * @param uid
	 * @param loginpass
	 * @param newpass
	 * @throws UserException 
	 */
	public void updatePassWord(String loginname,String loginpass,String newpass) throws UserException{
		try {
			//1.У��������
			boolean bool = userDao.findByPass(loginname, loginpass);
			if(!bool){
				throw new UserException("�����벻��ȷSERVIES");
			}
			//2.�޸�������
			userDao.updatePass(loginpass, newpass);
		} catch (SQLException e) {
			//У��ʧ��
			throw new RuntimeException(e);
		}
	}
	/**
	 * ���ݵ�¼������������û�
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
	 * �����
	 * @param code
	 */
	public void activation(String code){
		try {
			//1.�����û�
			User user = userDao.findByCode(code);
			//2.userΪnull���׳��쳣����ʾ��Ч����
			if(user==null)throw new UserException("��Ч����");
			//3.��Ϊnull����statusΪtrue��ʹ�׳��쳣����ʾ���ɶ��μ���
			if(user.isStatus())throw new UserException("���ɶ�����ʾ");
			//4.�޸��û�״̬Ϊtrue
//		user.setStatus(true);
			userDao.updateStatus(user.getUid(), true);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * У���û���
	 * */
	public boolean validateLoginName(String loginname){
		try {
			return userDao.validateLoginName(loginname);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * У��email
	 * */
	public boolean validateEmail(String email){
		try {
//			return validateEmail(email);   ���ݹ飺��java.lang.StackOverflowError�쳣
			return userDao.validateEmail(email);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * �����û�
	 * */
	public void regist(User user){
		//1.���ݲ���
		user.setUid(CommonUtils.uuid());
		user.setStatus(false);
		user.setActivationCode(CommonUtils.uuid()+CommonUtils.uuid());
		
		/*
		 * 2.���ݿ����
		 * */
		try {
			userDao.add(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		/*
//		 * 3.���ʼ�
//		 * */
//		/*
//		 * ���������ļ�
//		 * */
//		Properties prop = new Properties();
//		try {
//			prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		/*
//		 * ��¼������������õ�session
//		 * */
//		String host=prop.getProperty("host");//���������������
//		String username=prop.getProperty("username");//��¼��
//		String password = prop.getProperty("password");//��½����
//		Session session = MailUtils.createSession(host, username, password);
//		/*
//		 * ����Mail����
//		 * */
//		String from=prop.getProperty("from");
//		String to=user.getEmail();
//		String subject=prop.getProperty("subject");
//		//������ռλ�������
//		String content=MessageFormat.format(prop.getProperty("content"),user.getActivationCode());
//		Mail mail = new Mail(from,to,subject,content);
//		/*
//		 * �����ʼ�
//		 * */ 
//		try {
//			MailUtils.send(session, mail);
//		} catch (Exception e1) {
//			throw new RuntimeException(e1);
//		}
	}
	/**
	 * �����¼���ܣ�����û��Ƿ�����
	 * true�ѵ�½
	 * falseδ��¼
	 * @param username
	 * @param usernameList
	 * @return
	 */
	public boolean checkOnline(String username, List<String> usernameList) {
		boolean flag = true;           //trueΪ�ѵ�½��falseΪδ��¼
		if(usernameList.size()==0){ 
			flag = false;
			usernameList.add(username);//���usernameListΪ�գ���username��ӽ�ȥ
		}else{
			for(String un:usernameList){
				   if(un.equals(username)){//���ڸ��û���������true
					   flag = true;
					   return flag;
				   } 
				   flag = false;
				   usernameList.add(username);//���򲻴���
			}
		}
		return flag;
	}
}
