package com.ensa.gestionPharmacie.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Test;
import com.ensa.gestionPharmacie.entity.TestFils;

@Repository
public class TestDaoImpl implements TestDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Test> getAllTest() {
		
		List<Test> allTest = getSessionFactory().getCurrentSession().createQuery("from Test as t").list();
		return allTest;
	}
	@Transactional
	public List<Admin> getAllAdmins() {
		
		List<Admin> allAdmin = getSessionFactory().getCurrentSession().createQuery("from Admin as t ").list();
		return allAdmin;
	}
	@Transactional
	public void add(TestFils tf){
		getSessionFactory().getCurrentSession().save(tf);
		
	}
	@Transactional
	public void addP(Admin a){
		getSessionFactory().getCurrentSession().save(a);
		
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
}
