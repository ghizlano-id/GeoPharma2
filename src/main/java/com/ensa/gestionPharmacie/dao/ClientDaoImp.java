package com.ensa.gestionPharmacie.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Client;

@Repository
public class ClientDaoImp implements ClientDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional
	public void ajouterClient(Client client) {
		getSessionFactory().getCurrentSession().save(client);
		
	}
	
	
	//////////////////////////
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
