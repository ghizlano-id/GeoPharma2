package com.ensa.gestionPharmacie.service;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Pharmacie;


public interface PharmacieService {
	
	void ajouter(Pharmacie pharmacie);

	public List<Pharmacie> allPharmacie();
	public void supprimer(int idPharma);
	   public int getId(String id) ; 

}
