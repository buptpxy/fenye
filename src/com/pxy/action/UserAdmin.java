package com.pxy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pxy.domain.User;
import com.pxy.service.UserService;

public class UserAdmin extends ActionSupport {

	/**
	 * �û��б�
	 */
	private List<User> listUsers;
	/**
	 * ɾ����id
	 */
	private int deletId;
	/**
	 * �޸ĵ�id
	 */
	private int modifyId;
	/**
	 * �û�
	 */
	private User user;
	/**
	 * id
	 */
	private int id;
	/**
	 * �û���
	 */
	private String userName;
	/**
	 * ����
	 */
	private String password;
	/**
	 * ����
	 */
	private String email;
	/**
	 * �绰
	 */
	private String phone;
	/**
	 * �Ա�
	 */
	private String sex;
	/**
	 * ��ǰҳ��
	 */
	private int currentPage;
	/**
	 * ��ҳ��
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
	 * ��ҳ��ѯ
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
	 * ����idɾ��
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
	 * ǰ���޸�ҳ��
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
	 * �޸��û���Ϣ
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
			sex="Ů";
		}
		else
			sex="��";
		user.setSex(sex);
		user.setEmail(email);
		user.setPhone(phone);
		
		UserService us = new UserService();
		us.modify(user);
		listUsers = us.selectAll();
		return SUCCESS;
	}

}
