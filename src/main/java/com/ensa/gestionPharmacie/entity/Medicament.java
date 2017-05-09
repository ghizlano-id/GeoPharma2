package com.ensa.gestionPharmacie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Medicament {
	
	@Id
	private String nom ; 
	private double prix ; 
	private String description ; 
	private String photo ;
	
	@ManyToMany
	@JoinTable(name="pharmacie_medicament",joinColumns={@JoinColumn(name="nom")},
			inverseJoinColumns={@JoinColumn(name="idPharma")})
	private List<Pharmacie> pharmacies = new ArrayList<Pharmacie>() ; 
	
	
	
	
//---------------------getters & setters --------------------------------------	
	
	public List<Pharmacie> getPharmacies() {
		return pharmacies;
	}
	public void setPharmacies(List<Pharmacie> pharmacies) {
		this.pharmacies = pharmacies;
	}
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
