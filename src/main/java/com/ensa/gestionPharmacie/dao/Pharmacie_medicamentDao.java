package com.ensa.gestionPharmacie.dao;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;

public interface Pharmacie_medicamentDao {

	
	int Ajouter(Pharmacie_medicament pm) ; 
	void update(Pharmacie_medicament pm) ; 
	List<Pharmacie_medicament>  getPharmacies_medicament(String idMedica);
	public List<Pharmacie> getPharm_med(String med) ; 	
	

	
}
