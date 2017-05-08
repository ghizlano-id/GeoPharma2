package com.ensa.gestionPharmacie.service;

import com.ensa.gestionPharmacie.entity.Medicament;

public interface PharmacienService {

	boolean estPharmacien(String email , String password) ; 
	 void AjouterMed(Medicament m) ; 
	
}
