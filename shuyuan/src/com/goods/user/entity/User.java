package com.goods.user.entity;
/*
 * 实体类
 * */
public class User {
	/*包含
	 * 1.数据库数据
	 * 2.表单数据
	 * */
	//数据库数据
	private String uid;
	private String loginname;
	private String loginpass;
	private String email;
	private boolean status;
	private String activationCode;
	//表单数据
	private String repassword;//重置密码
	private String verifyCode;//验证码
	
	private String newpass;//新的验证码
	
	public String getNewpass() {
		return newpass;
	}
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpass() {
		return loginpass;
	}
	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
}
