package com.ensa.gestionPharmacie.dao;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacien;

public interface PharmacienDao {

	 boolean estPharmacien(String email , String password) ; 
	 void AjouterMed(Medicament m); 
	 void ajouter(Pharmacien pharmacien);
	
}
