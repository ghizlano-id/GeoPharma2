package com.ensa.gestionPharmacie.entity;

import javax.persistence.Entity;

	
	


import javax.persistence.OneToOne;

@Entity
public class Pharmacien extends Personne{
	private String password;
	@OneToOne(mappedBy="pharmacien")
	private Pharmacie pharmacie;

	//----------------Getters and setters-------------

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Pharmacien [password=" + password + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getTel()=" + getTel() + ", getEmail()=" + getEmail() + ", getCIN()=" + getCIN() + "]";
	}


	

}
