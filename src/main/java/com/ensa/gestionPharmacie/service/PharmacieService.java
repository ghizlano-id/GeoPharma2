package com.ensa.gestionPharmacie.service;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;


public interface PharmacieService {
	
	void ajouter(Pharmacie pharmacie);

	public List<Pharmacie> allPharmacie();
	public List<Pharmacie> getPharmacies(List<Pharmacie_medicament> list);
	public void supprimer(int idPharma);
	public int getId(String id) ; 
	public Pharmacie getPharmacie(double x,double y);
	Pharmacie getById(int id);
}
