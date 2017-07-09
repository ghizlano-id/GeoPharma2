package com.ensa.gestionPharmacie.dao;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
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
		
		//---------------- date-----------------------------------
		   Date date= new Date() ; 
		   // la date d'ajourd'hui a 12h.00.00
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
  

        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.AM_PM, Calendar.AM);

 
        // la date d'hier a 18h.0.0
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        calendar2.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-1);

        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.HOUR, 18);
        calendar2.set(Calendar.AM_PM, Calendar.AM);

         Timestamp t1 = new Timestamp(calendar.getTimeInMillis()) ;
         Timestamp t2 = new Timestamp(calendar2.getTimeInMillis()) ;
       
        System.out.println(calendar.getTimeInMillis());

        Query query = (Query) getSessionFactory().getCurrentSession().createQuery("from Commande as p where p.pharmacie.idPharma='"+id+"' and p.dateTime <= :from  and p.dateTime >= :to");
        ((org.hibernate.Query) query).setParameter("from", t1);
        ((org.hibernate.Query) query).setParameter("to", t2);
		List<Commande> list=getSessionFactory().getCurrentSession().createQuery("from Commande as p where p.pharmacie.idPharma='"+id+"'").list();
	   
		List<Commande> res=(List<Commande>) ((org.hibernate.Query) query).list() ; 
		     if(res==null)
		    	 return new  ArrayList<Commande>() ; 
		    			 
		     else 
		return   res;
	}

} 
