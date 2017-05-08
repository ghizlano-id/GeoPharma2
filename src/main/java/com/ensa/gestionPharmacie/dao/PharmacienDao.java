package com.ensa.gestionPharmacie.dao;

import com.ensa.gestionPharmacie.entity.Medicament;

public interface PharmacienDao {

	 boolean estPharmacien(String email , String password) ; 
	 void AjouterMed(Medicament m); 
	
}
