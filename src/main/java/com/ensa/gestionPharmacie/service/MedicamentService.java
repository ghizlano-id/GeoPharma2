package com.ensa.gestionPharmacie.service;

import java.util.List;
import java.util.Set;

import com.ensa.gestionPharmacie.entity.Medicament;

public interface MedicamentService {
	
	 void AjouterMed(Medicament m) ; 
     List<Medicament> All() ; 
     Set<Medicament> AllMedicamentDisp();
     Medicament getMedicament(String nomM);
}
