package com.ensa.gestionPharmacie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.CommandeDao;
import com.ensa.gestionPharmacie.entity.Client;
import com.ensa.gestionPharmacie.entity.Commande;

@Service
public class CommandeServiceImp implements CommandeService{

		@Autowired
		CommandeDao commandeDao;
		
		public void ajouter(Commande commande) {
			commandeDao.ajouter(commande);
			
		}
		
		///////////////////////////////////////
		public CommandeDao getCommandeDao() {
			return commandeDao;
		}

		public void setCommandeDao(CommandeDao commandeDao) {
			this.commandeDao = commandeDao;
		}

	
		public List<Commande>  getByIdPharma(int id) {
			// TODO Auto-generated method stub
			return commandeDao. getByIdPharma(id) ; 
		}

		public List<Commande>  getByIdPharma2(int id) {
			// TODO Auto-generated method stub
			return commandeDao. getByIdPharma2(id) ; 
		}
		
}
