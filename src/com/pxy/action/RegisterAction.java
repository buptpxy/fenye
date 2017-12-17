package com.pxy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pxy.domain.User;
import com.pxy.service.UserService;

public class RegisterAction extends ActionSupport {
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 电话
	 */
	private String phone;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
/**
 * 用户注册
 * @return
 * @throws Exception
 */
	public String register() throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(userName);	
		user.setPassword(password);
		System.out.println(userName+"  "+password);
		if("0".equals(sex)){
			sex="女";
		}
		else
			sex="男";
		user.setSex(sex);
		user.setEmail(email);
		user.setPhone(phone);
		UserService us = new UserService();
		if (us.hasSameName(user)==true){
			us.saveUser(user);
			return SUCCESS;
		}
		else{
			this.addFieldError(userName, "此用户名已被注册！");
			return ERROR;
		}
	}
}
