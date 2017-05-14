package com.ensa.gestionPharmacie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.PharmacieDao;
import com.ensa.gestionPharmacie.entity.Pharmacie;

@Service
public class PharmacieServiceImpl implements PharmacieService{
	
	@Autowired
	private PharmacieDao pharmacieDao;

	////::::::Getters and setters
	public PharmacieDao getPharmacieDao() {
		return pharmacieDao;
	}

	public void setPharmacieDao(PharmacieDao pharmacieDao) {
		this.pharmacieDao = pharmacieDao;
	}

	///////////////////////////////////////////////////
	public void ajouter(Pharmacie pharmacie) {
		pharmacieDao.ajouer(pharmacie);
	}

	public List<Pharmacie> allPharmacie() {
		return pharmacieDao.allPharmacie();
	}

	public void supprimer(int idPharma) {
		pharmacieDao.supprimer(idPharma);
	}
	   public int getId(String id) 
	   {
		   
		   
		 return  pharmacieDao.getId(id) ; 
		   
	   }
}
