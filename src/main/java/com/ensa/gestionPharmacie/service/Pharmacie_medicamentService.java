package com.ensa.gestionPharmacie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;

public interface Pharmacie_medicamentService {

	int Ajouter(Pharmacie_medicament pm) ; 
 public void update(Pharmacie_medicament pm)  ; 
 public List<Pharmacie> getPharm_med(String med) ; 	
	
}
