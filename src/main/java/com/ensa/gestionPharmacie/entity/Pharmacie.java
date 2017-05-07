package com.ensa.gestionPharmacie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private boolean estGarde;
	@OneToOne
	@JoinColumn(name="id")
	private Pharmacien pharmacien;
	
	
	//Getters and setters
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
