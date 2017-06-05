package com.ensa.gestionPharmacie.entity;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Pharmacie {
	@Id
	@JsonIgnore
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPharma;
	private String name;
	private String adresse;
	private double x;
	private double y;
	@Column(nullable = false)
	private boolean estGarde;
	@OneToOne
	@JsonIgnore
	@JoinColumn(name="CIN")
	private Pharmacien pharmacien;
	
	@JsonIgnore
	@OneToMany(mappedBy="pharmacie")
	private List<Pharmacie_medicament> pharmacie_qt = new ArrayList<Pharmacie_medicament>() ;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="pharmacie")
	private List<Commande> commandes= new ArrayList<Commande>();
	

	//Getters and setters
	
	/*@OneToMany(targetEntity=pharmacie_medicament.class , mappedBy="pharmacie" , cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<pharmacie_medicament> getPharmacie_qt() {
		return pharmacie_qt;
	}
	public void setPharmacie_qt(List<pharmacie_medicament> pharmacies) {
		this.pharmacie_qt = pharmacies;
	}
	*/
	
	public List<Pharmacie_medicament> getPharmacie_qt() {
		return pharmacie_qt;
	}
	public void setPharmacie_qt(List<Pharmacie_medicament> pharmacies) {
		this.pharmacie_qt = pharmacies;
	}
	
	
	public int getIdPharma() {
		return idPharma;
	}
	public void setIdPharma(int idPharma) {
		this.idPharma = idPharma;
	}
	public Pharmacien getPharmacien() {
		return pharmacien;
	}
	public void setPharmacien(Pharmacien pharmacien) {
		this.pharmacien = pharmacien;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public boolean isEstGarde() {
		return estGarde;
	}
	public void setEstGarde(boolean estGarde) {
		this.estGarde = estGarde;
	}

	
}
