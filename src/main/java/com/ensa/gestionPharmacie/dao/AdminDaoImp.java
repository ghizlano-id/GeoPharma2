package com.ensa.gestionPharmacie.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Test;

@Repository
public class AdminDaoImp implements AdminDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean estAdmin(String email, String password) {
		List<Admin> list=getSessionFactory().getCurrentSession().
							createQuery("from Admin as a where a.email='"+email+"' and a.password='"+password+"'").list();
		
		if(list!=null && list.size()>0)
			return true;
		else 
			return false;
	}
	
	//////////////////////////
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
