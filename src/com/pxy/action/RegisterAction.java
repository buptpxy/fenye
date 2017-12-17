package com.pxy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pxy.domain.User;
import com.pxy.service.UserService;

public class RegisterAction extends ActionSupport {
	/**
	 * �û���
	 */
	private String userName;
	/**
	 * ����
	 */
	private String password;
	/**
	 * �Ա�
	 */
	private String sex;
	/**
	 * ����
	 */
	private String email;
	/**
	 * �绰
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
 * �û�ע��
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
			sex="Ů";
		}
		else
			sex="��";
		user.setSex(sex);
		user.setEmail(email);
		user.setPhone(phone);
		UserService us = new UserService();
		if (us.hasSameName(user)==true){
			us.saveUser(user);
			return SUCCESS;
		}
		else{
			this.addFieldError(userName, "���û����ѱ�ע�ᣡ");
			return ERROR;
		}
	}
}
