package com.ensa.gestionPharmacie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.Pharmacie_medicamentDao;
import com.ensa.gestionPharmacie.entity.Pharmacie;
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
	

	public int Ajouter(Pharmacie_medicament pm) 
	{
		
	 return	pmd.Ajouter(pm);
		
	}
	
//------------------------------------------------
	
	public void update(Pharmacie_medicament pm) 
	{
		pmd.update(pm);
		
	}


	public List<Pharmacie> getPharm_med(String med) {
		return pmd.getPharm_med(med) ; 
	}

	public void updateQantite(String idMed, int idPharma) {
		pmd.updateQantite(idMed, idPharma);
		
	}
	
	
}



