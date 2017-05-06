package com.ensa.gestionPharmacie.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestMain {

	public static void main(String[] args) {

		TestFils test= new TestFils();
		//student.setIds(14);
		test.setName("houyam");
		test.setNickname("hoy");
		
		SessionFactory factory=new Configuration().
				                   configure().
				                   addAnnotatedClass(TestFils.class).
				                   buildSessionFactory();
        Session session=factory.getCurrentSession();
       try{
    	   session.beginTransaction();
    	   session.save(test);
    	   
    	  session.getTransaction().commit(); 
       }
       finally{
           session.close();
           factory.close();}

	}

}
