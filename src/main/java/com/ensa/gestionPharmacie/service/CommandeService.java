package com.ensa.gestionPharmacie.service;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Client;
import com.ensa.gestionPharmacie.entity.Commande;

public interface CommandeService {
	
	public void ajouter(Commande commande);

	public List<Commande> getByIdPharma(int id) ; 
}
