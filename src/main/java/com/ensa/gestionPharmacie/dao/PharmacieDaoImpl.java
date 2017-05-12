package com.ensa.gestionPharmacie.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Pharmacie;

@Repository
public class PharmacieDaoImpl implements PharmacieDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	////////////////////////////////
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
	
   /////////////////////////////
	@Transactional
	public void ajouer(Pharmacie pharmacie) {
		getSessionFactory().getCurrentSession().save(pharmacie);
	}
	@Transactional
	public List<Pharmacie> allPharmacie() {
		List<Pharmacie> list=getSessionFactory().getCurrentSession().createQuery("from Pharmacie as p").list();
		return list;
	}
	@Transactional
	public void supprimer(int idPharma) {
		Pharmacie pharmacie=(Pharmacie) getSessionFactory().getCurrentSession().get(Pharmacie.class,idPharma);
		getSessionFactory().getCurrentSession().delete(pharmacie);
	}
	
	

}
