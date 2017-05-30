package com.ensa.gestionPharmacie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;
import com.ensa.gestionPharmacie.entity.key2;
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
		public int Ajouter(Pharmacie_medicament pm) {
			int i=0 ; 
			List<Pharmacie_medicament> list=getSessionFactory().getCurrentSession().createQuery("from Pharmacie_medicament as p where p.medicament.nom='"+pm.getMedicament().getNom()+"' and p.pharmacie.idPharma='"+pm.getPharmacie().getIdPharma()+"' ").list();
			
			if(list.size()==0)
				
			{
				i=1 ; 
				getSessionFactory().getCurrentSession().save(pm);
			
			}
			return i ; 
		}
////////////////////////////////////////////////////////////
		
		@Transactional
		public void update(Pharmacie_medicament pm) {
			
			/*
			List<Pharmacie_medicament> = getSessionFactory().getCurrentSession().createQuery("from Pharmacie_medicament as p where p.medicament.nom='"+pm.getMedicament().getNom()+"'").list();
			if(list.size()>1)
			{
				Pharmacie_medicament p=(Pharmacie_medicament) getSessionFactory().getCurrentSession().get(Pharmacie_medicament.class,list.get(0).getId()) ;
				double qt=list.get(0).getQuantite() ; 
				qt=qt+pm.getQuantite() ; 
				p.setQuantite(qt);
			}
			else
				System.out.println("nnnnnnnnnnnnnnnnnnnn");*/
			//int id=getId(pm.getMedicament().getNom(), pm.getPharmacie().getIdPharma()) ; 
			key2 id=new key2() ; 
			Medicament m= new Medicament() ; 
			m.setNom(pm.getMedicament().getNom());
			Pharmacie p=new Pharmacie() ; 
			p.setIdPharma(pm.getPharmacie().getIdPharma());
			id.setMedicament(m)  ;
			id.setPharmacie(p);
			Pharmacie_medicament phm=(Pharmacie_medicament) getSessionFactory().getCurrentSession().get(Pharmacie_medicament.class, id) ; 
			phm.setQuantite(phm.getQuantite()+pm.getQuantite());
			// getSessionFactory().getCurrentSession().update(pm);
		}
		

	
}
