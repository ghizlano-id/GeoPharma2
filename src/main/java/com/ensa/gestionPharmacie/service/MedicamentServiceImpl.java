package com.ensa.gestionPharmacie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.MedicamentDao;
import com.ensa.gestionPharmacie.entity.Medicament;



@Service
public class MedicamentServiceImpl implements MedicamentService {

	
	@Autowired
	private MedicamentDao medicamentDao ;

	//----------------getters & setters --------------------
	
	public MedicamentDao getMedicamentDao() {
		return medicamentDao;
	}

	public void setMedicamentDao(MedicamentDao medicamentDao) {
		this.medicamentDao = medicamentDao;
	} 
	
	public void AjouterMed(Medicament m) {
		
		 medicamentDao.AjouterMed(m);
	}

	
}
