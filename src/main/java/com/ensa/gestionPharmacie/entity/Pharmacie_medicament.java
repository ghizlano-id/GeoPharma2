package com.ensa.gestionPharmacie.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(key2.class)
public class Pharmacie_medicament {

	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ; */
	
	private double quantite ; 
	@Id
	@ManyToOne
	@JoinColumn(name="nom")
	private Medicament medicament ;
	@Id
	@ManyToOne
	@JoinColumn(name="idPharma")
	private Pharmacie pharmacie  ;
	
	
	
	//---------------------getters & setters-------------------------
	
	
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}


	public Pharmacie getPharmacie() {
		return pharmacie;
	}
	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	} 
	public Pharmacie_medicament() {
		super();
		// TODO Auto-generated constructor stub

	}
	
	public Pharmacie_medicament( double quantite, Medicament medicament) {
		super();
		//this.id = id;
		this.quantite = quantite;
		this.medicament = medicament;
	}
	
	
	
}

