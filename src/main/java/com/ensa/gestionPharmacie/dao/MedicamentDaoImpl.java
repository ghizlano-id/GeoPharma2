package com.ensa.gestionPharmacie.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;



@Repository
public class MedicamentDaoImpl implements MedicamentDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	//-----------getters & setters -----------
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public void AjouterMed(Medicament m) {
		getSessionFactory().getCurrentSession().save(m);
		
	}
	@Transactional
	public  List<Medicament> All() 
	 {
		List<Medicament> list=getSessionFactory().getCurrentSession().createQuery("from Medicament as p").list();
		return list;
		
		
		
	 }
	
}
