package com.ensa.gestionPharmacie.service;



import com.ensa.gestionPharmacie.entity.Pharmacien;

public interface PharmacienService {

	boolean estPharmacien(String email,String password) ; 
	 
	 void ajouter(Pharmacien pharmacien);
	 Pharmacien getPharmacien(String CIN);

		
}
