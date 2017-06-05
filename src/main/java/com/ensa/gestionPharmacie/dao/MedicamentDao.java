package com.ensa.gestionPharmacie.dao;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Medicament;

public interface MedicamentDao {

	 void AjouterMed(Medicament m); 
	 List<Medicament> All() ; 
	 Medicament getMedicament(String nomM);
	
	
}
