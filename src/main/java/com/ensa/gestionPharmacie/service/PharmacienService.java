package com.ensa.gestionPharmacie.service;



import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacien;

public interface PharmacienService {

	String estPharmacien(String email,String password) ; 
	 
	 void ajouter(Pharmacien pharmacien);
	 Pharmacien getPharmacien(String CIN);
	 void supprimer(String CIN);

		
}
