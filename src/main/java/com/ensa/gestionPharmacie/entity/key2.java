package com.ensa.gestionPharmacie.entity;

import java.io.Serializable;

public class key2 implements Serializable {

	protected Medicament medicament ; 
	protected Pharmacie pharmacie ;
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	public Pharmacie getPharmacie() {
		return pharmacie;
	}
	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	
}
