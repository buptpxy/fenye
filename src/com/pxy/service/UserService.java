package com.pxy.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pxy.domain.User;
import com.pxy.util.HibernateUtil;

public class UserService {
	Session session = null;
	Transaction ts = null;

	
	/**
	 * ��¼ʱ��ѯ�Ƿ��д��û�
	 * @param user
	 * @return
	 */
	public boolean checkUser(User user) {
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from User where userName = ? and password = ?");
		query.setString(0, user.getUserName());
		query.setString(1, user.getPassword());
		List<User> list = query.list();
		HibernateUtil.closeSession(session);
		if (list.size() > 0) {
			return true;
		} else
			return false;

	}
	/**
	 * ע��ʱ��ѯ�Ƿ��д��û�
	 * @param user
	 * @return
	 */
	public boolean hasSameName(User user) {
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from User where userName = ?");
		query.setString(0, user.getUserName());
		List<User> list = query.list();
		HibernateUtil.closeSession(session);
		if (list.size() > 0) {
			return false;
		} else
			return true;

	}
	/**
	 * ע��ʱ�����û�
	 * @param user
	 * @return
	 */
	public void saveUser(User user) {
		try {
			session = HibernateUtil.openSession();
			ts = session.beginTransaction();
			session.save(user);
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
		}
	}
	/**
	 * ��ѯ�����û�����ʾ����
	 * @param user
	 * @return list
	 */
	public List<User> selectAll() {
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		HibernateUtil.closeSession(session);
		return list;
	}
	/**
	 * �����û�ID����
	 * @param id
	 * @return user
	 */
	public User selectById(int id){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from User where id = ?");
		query.setParameter(0, id);
		User user = (User) query.uniqueResult();
		HibernateUtil.closeSession(session);
		return user;
	}
	/**
	 * ɾ����ӦID���û�
	 * @param id
	 * @return 
	 */
	public  boolean deleteById(int id){
		try {
			session = HibernateUtil.openSession();
			ts = session.beginTransaction();
			String hql = "delete User where id = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			query.executeUpdate();
			ts.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
				return false;
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
		}
	}
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return 
	 */
	public void modify(User user){
		try {
			session = HibernateUtil.openSession();
			ts = session.beginTransaction();
			session.update(user);
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null) {
				HibernateUtil.closeSession(session);
			}
		}
	}
	/**
	 * �ܵ��û���
	 * @return list.size()
	 */
	public int getCount(){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		HibernateUtil.closeSession(session);
		return list.size();
	}
	/**
	 * �ڼ�ҳ
	 * @param count
	 * @param pageSize
	 * @return count/pageSize + 1
	 */
	public int getPageCount(int count,int pageSize){
		int remain = count % pageSize;
		if(remain==0){
			return count/pageSize;
		}
		else
			return count/pageSize + 1;
	}
	
	/**
	 * ��ǰҳ��ʾ���û��б�
	 * @param CurrentPage
	 * @param pageSize
	 * @return list
	 */
	public List<User> getCurrentPageUsers(int CurrentPage,int pageSize){
		session = HibernateUtil.openSession();
		Query query = session.createQuery("from User");
		query.setFirstResult((CurrentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<User> list = query.list();
		HibernateUtil.closeSession(session);
		return list;
	}
}
