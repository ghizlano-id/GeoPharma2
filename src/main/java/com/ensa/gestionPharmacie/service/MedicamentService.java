package com.ensa.gestionPharmacie.service;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Medicament;

public interface MedicamentService {
	
	 void AjouterMed(Medicament m) ; 
     List<Medicament> All() ; 
     Medicament getMedicament(String nomM);
}
