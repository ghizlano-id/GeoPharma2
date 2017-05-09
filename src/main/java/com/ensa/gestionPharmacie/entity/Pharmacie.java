package com.ensa.gestionPharmacie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Pharmacie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPharma;
	
	private String name;
	private String adresse;
	private double x;
	private double y;
	@Column(nullable = false)
	private boolean estGarde;
	@OneToOne
	@JoinColumn(name="CIN")
	private Pharmacien pharmacien;
	
	@ManyToMany
	@JoinTable(name="pharmacie_medicament",joinColumns={@JoinColumn(name="idPharma")},
			inverseJoinColumns={@JoinColumn(name="idMed")}
			)
	private List<Medicament> medicaments = new ArrayList<Medicament>() ; 
	
	

	//Getters and setters
	
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
	public List<Medicament> getMedicaments() {
		return medicaments;
	}
	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
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
