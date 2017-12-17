package com.pxy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pxy.domain.User;
import com.pxy.service.UserService;

public class UserAdmin extends ActionSupport {

	/**
	 * 用户列表
	 */
	private List<User> listUsers;
	/**
	 * 删除的id
	 */
	private int deletId;
	/**
	 * 修改的id
	 */
	private int modifyId;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * id
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 当前页码
	 */
	private int currentPage;
	/**
	 * 总页数
	 */
	private int totalPage;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	public int getDeletId() {
		return deletId;
	}

	public void setDeletId(int deletId) {
		this.deletId = deletId;
	}

	public int getModifyId() {
		return modifyId;
	}

	public void setModifyId(int modifyId) {
		this.modifyId = modifyId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

	@Override
	/**
	 * 分页查询
	 */
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(currentPage==0){
			currentPage = 1;
		}
		
		int pageSize = 5;
		UserService us = new UserService();
		int count = us.getCount();
		totalPage = us.getPageCount(count, pageSize);
		if(currentPage>totalPage){
			currentPage = totalPage;
		}
		listUsers = us.getCurrentPageUsers(currentPage, pageSize);
		return SUCCESS;
	}
	
	/**
	 * 根据id删除
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String del() throws Exception {
		// TODO Auto-generated method stub
		UserService us = new UserService();
		us.deleteById(deletId);
		listUsers = us.selectAll();
		return SUCCESS;
	}
	/**
	 * 前往修改页面
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String toModify() throws Exception {
		// TODO Auto-generated method stub
		UserService us = new UserService();
		user = us.selectById(modifyId);
		
		return SUCCESS;
	}
	
	/**
	 * 修改用户信息
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String modify() throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		if("0".equals(sex)){
			sex="女";
		}
		else
			sex="男";
		user.setSex(sex);
		user.setEmail(email);
		user.setPhone(phone);
		
		UserService us = new UserService();
		us.modify(user);
		listUsers = us.selectAll();
		return SUCCESS;
	}

}
