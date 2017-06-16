package com.ensa.gestionPharmacie.dao;

import com.ensa.gestionPharmacie.entity.Client;

public interface ClientDao {
	public void ajouterClient(Client c);
    public boolean existeClient(String CIN);

}
