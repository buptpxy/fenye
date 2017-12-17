package com.pxy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pxy.domain.User;
import com.pxy.service.UserService;

public class LoginAction extends ActionSupport {
	/**
	 * �û���
	 */
	private String userName;
	/**
	 * ����
	 */
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
/**
 * �û���¼
 * @return
 * @throws Exception
 */
	public String Login() throws Exception {
		// TODO Auto-generated method stub
		UserService us = new UserService();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		System.out.println(userName +"       "+password);
		if (us.checkUser(user)==true){
			return SUCCESS;
		}
		else{
			this.addFieldError(userName,"�û��������벻��ȷ��");
			return ERROR;
		}
	}
}
