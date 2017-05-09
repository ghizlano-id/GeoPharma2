package com.ensa.gestionPharmacie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.ValueGenerationType;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
public class Personne {
	@Id
	private String CIN;
	/*@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;*/
	@Column
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	
	
	//--------Getters and Setters------------
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	

}
