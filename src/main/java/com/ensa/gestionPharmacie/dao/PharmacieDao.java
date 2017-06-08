package com.ensa.gestionPharmacie.dao;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;



public interface PharmacieDao {
	
	public void ajouer(Pharmacie pharmacie);
	public List<Pharmacie> allPharmacie();
	public List<Pharmacie> getPharmacies(List<Pharmacie_medicament> list);
	public void supprimer(int idPharma);
    public int getId(String id) ; 
    Pharmacie getPharmacie(double x,double y);


}
