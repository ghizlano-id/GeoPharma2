package com.ensa.gestionPharmacie.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Commande;

@Repository
public class CommandeDaoImpl implements CommandeDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void ajouter(Commande commande) {
		sessionFactory.getCurrentSession().save(commande);

	}

	//////////////////////////
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
