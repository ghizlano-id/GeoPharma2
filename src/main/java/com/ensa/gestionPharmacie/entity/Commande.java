package com.ensa.gestionPharmacie.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Commande {
	@Id
    private int idCmd;
	private int quantite;
	@ManyToOne(cascade=CascadeType.ALL)
	private Client client;
	@ManyToOne(cascade=CascadeType.ALL)
	private Medicament medicament;
	@ManyToOne(cascade=CascadeType.ALL)
	private Pharmacie pharmacie;
	
	public int getIdCmd() {
		return idCmd;
	}
	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}
