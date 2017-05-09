package com.ensa.gestionPharmacie.service;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacien;

public interface PharmacienService {

	boolean estPharmacien(String email,String password) ; 
	 void AjouterMed(Medicament m) ; 
	 void ajouter(Pharmacien pharmacien);
	
}
