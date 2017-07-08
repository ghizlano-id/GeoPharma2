package com.ensa.gestionPharmacie.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.MedicamentDao;
import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;



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
	public List<Medicament> All()
	{
		
		return medicamentDao.All() ; 
	}

	public Medicament getMedicament(String nomM) {
		
		return medicamentDao.getMedicament(nomM);
	}

	public Set<Medicament> AllMedicamentDisp() {
		
		return medicamentDao.AllMedicamentDisp();
	}

	@Override
	public List<Medicament> getMedByPharma(int idPharma) {
		// TODO Auto-generated method stub
		return medicamentDao.getMedByPharma(idPharma);
	}

	@Override
	public List<Pharmacie_medicament> getMedByPharma2(int idPharma) {
		// TODO Auto-generated method stub
		return medicamentDao.getMedByPharma2(idPharma);
	}
	
}
