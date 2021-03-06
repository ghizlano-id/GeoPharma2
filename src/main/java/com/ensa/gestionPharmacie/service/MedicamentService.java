package com.ensa.gestionPharmacie.service;

import java.util.List;
import java.util.Set;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;

public interface MedicamentService {
	
	 void AjouterMed(Medicament m) ; 
     List<Medicament> All() ; 
     Set<Medicament> AllMedicamentDisp();
     Medicament getMedicament(String nomM);
     List<Medicament>  getMedByPharma(int idPharma);
     List<Pharmacie_medicament> getMedByPharma2(int idPharma)  ; 
}
