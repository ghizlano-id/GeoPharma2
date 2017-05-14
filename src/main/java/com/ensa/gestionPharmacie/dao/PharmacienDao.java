package com.ensa.gestionPharmacie.dao;



import com.ensa.gestionPharmacie.entity.Pharmacien;


public interface PharmacienDao {

	 String estPharmacien(String email , String password) ; 
	 void ajouter(Pharmacien pharmacien);
	 Pharmacien getPharmacien(String CIN);
	 void supprimer(String CIN);
	 
}
