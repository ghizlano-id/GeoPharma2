package com.ensa.gestionPharmacie.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;

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
	
 ////////////////////////////////
	@Transactional
	public int getId(String id) {
	List<Pharmacie> list= getSessionFactory().getCurrentSession().createQuery("from Pharmacie as p where p.pharmacien.CIN='"+id+"'").list();
		return list.get(0).getIdPharma();
	}
	@Transactional
	public List<Pharmacie> getPharmacies(List<Pharmacie_medicament> list) {
		List<Pharmacie> listPharmacies= new ArrayList<Pharmacie>();
		 for(Pharmacie_medicament p:list){
			 Pharmacie pharmacie=(Pharmacie) getSessionFactory().getCurrentSession().get(Pharmacie.class,p.getPharmacie().getIdPharma());
			 listPharmacies.add(pharmacie);
		 }
		return listPharmacies;
	}
	@Transactional
	public Pharmacie getPharmacie(double x, double y) {
		List<Pharmacie> list=getSessionFactory().getCurrentSession().createQuery("from Pharmacie as p where p.x="+x+" and p.y="+y).list();
		return list.get(0);
	}

}
