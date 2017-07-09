package com.ensa.gestionPharmacie.dao;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Client;
import com.ensa.gestionPharmacie.entity.Commande;

public interface CommandeDao {
	public void ajouter(Commande commande);
   public List<Commande> getByIdPharma(int id) ; 
   public List<Commande> getByIdPharma2(int id)  ; 
}
