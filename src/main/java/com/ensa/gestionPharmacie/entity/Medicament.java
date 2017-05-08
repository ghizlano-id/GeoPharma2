package com.ensa.gestionPharmacie.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medicament {
	
	@Id
	private String nom ; 
	private double prix ; 
	private String description ; 
	private String photo ;
	
//---------------------getters & setters --------------------------------------	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

// ----------------------Constructor----------------------------------------
	
	public Medicament(String nom, double prix, String description, String photo) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.photo = photo;
	}
	public Medicament() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Medicament [nom=" + nom +  ", prix=" + prix + ", description=" + description + ", photo=" + photo + "]";
	} 
	
	
	
	
}
