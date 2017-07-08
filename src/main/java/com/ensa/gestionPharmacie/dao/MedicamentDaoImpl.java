package com.ensa.gestionPharmacie.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;
import com.ensa.gestionPharmacie.entity.Pharmacien;



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
	@Transactional
	public Medicament getMedicament(String nomM) {
		Medicament medicament=new Medicament();

		medicament=(Medicament) getSessionFactory().getCurrentSession().get(Medicament.class,nomM);

		return medicament;
	}
	@Transactional
	public Set<Medicament> AllMedicamentDisp() {
		String q="select m from Medicament  m  JOIN m.pharmacie_qt mq where mq.quantite!=0";
		List<Medicament> liste= getSessionFactory().getCurrentSession().createQuery(q).list();
		Set<Medicament> medicaments= new HashSet<Medicament>();
		medicaments.addAll(liste);
		return medicaments;
	}
	@Transactional
	public List<Medicament> getMedByPharma(int idPharma) {
		List<Pharmacie_medicament> list=getSessionFactory().getCurrentSession().createQuery("from Pharmacie_medicament as p where p.pharmacie.idPharma="+idPharma).list();
		List<Medicament> l= new ArrayList<Medicament>() ; 
		for(Pharmacie_medicament p : list)
			l.add(p.getMedicament()) ; 
		
		
		return l;
	}
	
	@Transactional
	public List<Pharmacie_medicament> getMedByPharma2(int idPharma) {
		List<Pharmacie_medicament> list=getSessionFactory().getCurrentSession().createQuery("from Pharmacie_medicament as p where p.pharmacie.idPharma="+idPharma).list();

		
		return list;
	}
	
	
	
}
