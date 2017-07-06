package com.ensa.gestionPharmacie.dao;

import java.util.List;
import java.util.Set;

import com.ensa.gestionPharmacie.entity.Medicament;

public interface MedicamentDao {

	 void AjouterMed(Medicament m); 
	 List<Medicament> All() ; 
	 Set<Medicament> AllMedicamentDisp();
	 Medicament getMedicament(String nomM);
	
	
}
