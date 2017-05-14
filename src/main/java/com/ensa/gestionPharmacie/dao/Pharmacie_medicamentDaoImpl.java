package com.ensa.gestionPharmacie.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;
@Repository
public class Pharmacie_medicamentDaoImpl implements Pharmacie_medicamentDao  {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	////////////////////////////////
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
//////////////////////////////////////////
		@Transactional
		public void Ajouter(Pharmacie_medicament pm) {
			getSessionFactory().getCurrentSession().save(pm);
		}

	
}
