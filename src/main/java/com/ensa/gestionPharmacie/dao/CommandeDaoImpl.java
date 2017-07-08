package com.ensa.gestionPharmacie.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Client;
import com.ensa.gestionPharmacie.entity.Commande;
import com.ensa.gestionPharmacie.entity.Medicament;

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

	@Transactional
	public List<Commande> getByIdPharma(int id)  {
		List<Commande> list=getSessionFactory().getCurrentSession().createQuery("from Commande as p where p.pharmacie.idPharma='"+id+"'").list();
	
		return list;
	}

}
