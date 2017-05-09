package com.ensa.gestionPharmacie.service;

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

}
