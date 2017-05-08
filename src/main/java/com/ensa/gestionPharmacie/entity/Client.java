package com.ensa.gestionPharmacie.entity;

import javax.persistence.Entity;

@Entity
public class Client  extends Personne{

	private String adresse ; 
	private double x ;
	private double y ;

	
//--------------getters & setters ------------------------------------------
	
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

	
//----------------------Constructor-------------------------
	
	public Client(String adresse, double x, double y) {
		super();
		this.adresse = adresse;
		this.x = x;
		this.y = y;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Client [adresse=" + adresse + ", x=" + x + ", y=" + y + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getTel()=" + getTel() + ", getEmail()=" + getEmail() + ", getCIN()=" + getCIN()
				+ ", toString()=" + super.toString() + "]";
	} 
	
	
	
	
}
