package com.ensa.gestionPharmacie.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public void add(TestFils tf){
		getSessionFactory().getCurrentSession().save(tf);
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
