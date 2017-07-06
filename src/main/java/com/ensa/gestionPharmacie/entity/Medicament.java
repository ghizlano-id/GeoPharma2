package com.ensa.gestionPharmacie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;


import javax.persistence.Id;


import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Medicament{
	@Id
	private String nom ; 
	private double prix  ; 
	private String designation ; 
	private String photo ; 
	@JsonIgnore
	@OneToMany(mappedBy="medicament")
	private List<Pharmacie_medicament> pharmacie_qt = new ArrayList<Pharmacie_medicament>() ;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="medicament")
	private List<Commande> commandes= new ArrayList<Commande>();
//-------------------------getters & setters ----------------------------
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<Pharmacie_medicament> getPharmacie_qt() {
		return pharmacie_qt;
	}
	public void setPharmacie_qt(List<Pharmacie_medicament> pharmacie_qt) {
		this.pharmacie_qt = pharmacie_qt;
	}
	
//---------------------------Constructors----------------------------------------------	

	
	
}