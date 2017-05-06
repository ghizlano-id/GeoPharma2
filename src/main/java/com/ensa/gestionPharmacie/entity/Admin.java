package com.ensa.gestionPharmacie.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends Personne{
	
	
	private String password;
	
	//---------Getters and setters
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Admin [password=" + password + ", getPassword()=" + getPassword() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getTel()=" + getTel() + ", getEmail()=" + getEmail()
				+ ", getCIN()=" + getCIN() + "]";
	}

}
