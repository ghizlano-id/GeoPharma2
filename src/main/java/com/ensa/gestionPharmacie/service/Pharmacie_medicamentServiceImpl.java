package com.ensa.gestionPharmacie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.Pharmacie_medicamentDao;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;

@Service
public class Pharmacie_medicamentServiceImpl  implements Pharmacie_medicamentService {
	
	@Autowired
	private Pharmacie_medicamentDao pmd ;
	
//--------------------getters & setters -------------------------
	public Pharmacie_medicamentDao getPmd() {
		return pmd;
	}

	public void setPmd(Pharmacie_medicamentDao pmd) {
		this.pmd = pmd;
	} 
	

	public void Ajouter(Pharmacie_medicament pm) 
	{
		
		pmd.Ajouter(pm);
		
	}
	
}



