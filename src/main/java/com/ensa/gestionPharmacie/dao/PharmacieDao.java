package com.ensa.gestionPharmacie.dao;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Pharmacie;



public interface PharmacieDao {
	
	public void ajouer(Pharmacie pharmacie);
	public List<Pharmacie> allPharmacie();
	public void supprimer(int idPharma);

}
