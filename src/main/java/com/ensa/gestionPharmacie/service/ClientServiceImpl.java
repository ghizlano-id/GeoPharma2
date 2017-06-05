package com.ensa.gestionPharmacie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.ClientDao;
import com.ensa.gestionPharmacie.entity.Client;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientDao clientDao;
	
	public void ajouterClient(Client client) {
		clientDao.ajouterClient(client);
		
	}
	
	
	
	
	
	
	////////////////////////////////////
	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	

}
