package com.ensa.gestionPharmacie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.CommandeDao;
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

		
}
