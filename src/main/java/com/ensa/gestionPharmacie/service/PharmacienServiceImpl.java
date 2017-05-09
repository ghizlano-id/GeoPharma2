package com.ensa.gestionPharmacie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.PharmacienDao;
import com.ensa.gestionPharmacie.entity.Pharmacien;


@Service
public class PharmacienServiceImpl implements PharmacienService {

	
	@Autowired
	private PharmacienDao pharmacienDao ; 
	
	//-----------------getters & setters ------------------
	
	public PharmacienDao getPharmacienDao() {
		return pharmacienDao;
	}
	public void setPharmacienDao(PharmacienDao pharmacienDao) {
		this.pharmacienDao = pharmacienDao;
	}


	
	public boolean estPharmacien(String email, String password) {
		
		return pharmacienDao.estPharmacien(email, password) ; 
	}


	public void ajouter(Pharmacien pharmacien){
		pharmacienDao.ajouter(pharmacien);
	}
	
}
