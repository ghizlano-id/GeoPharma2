package com.ensa.gestionPharmacie.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacien;



@Repository
public class PharmacienDaoImpl implements PharmacienDao{
	
	
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
	public String estPharmacien(String email , String password) {
	
		
		List<Pharmacien> allPh = getSessionFactory().getCurrentSession().createQuery("from Pharmacien as t where t.email='"+email+"' and t.password='"+password+"' ").list();
		  if(allPh!=null && allPh.size()==1 )
		 return allPh.get(0).getCIN() ; 
		  else
		return "empty";
	}

	
	@Transactional
	 public void ajouter(Pharmacien pharmacien){
		getSessionFactory().getCurrentSession().save(pharmacien);
		}
	
	@Transactional
	public Pharmacien getPharmacien(String CIN) {
		Pharmacien pharmacien=new Pharmacien();
		
		pharmacien=(Pharmacien) getSessionFactory().getCurrentSession().get(Pharmacien.class,CIN);
		
		return pharmacien;
	}
	@Transactional
	public void supprimer(String CIN) {
		Pharmacien pharmacien=(Pharmacien) getSessionFactory().getCurrentSession().get(Pharmacien.class,CIN);
		getSessionFactory().getCurrentSession().delete(pharmacien);
		
	}


	

	
}
