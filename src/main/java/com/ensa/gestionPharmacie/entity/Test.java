package com.ensa.gestionPharmacie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class Test {

	@Id
	@GeneratedValue
	private Integer idTest;
	
	@Column(name = "name")
	private String name;
	
	//------------------ constructeur Sans ID ------------------
	public Test(String name) {
		super();
		this.name = name;
	}
	
	public Test() {
		
	}

	//------------------ getter & setter ------------------
	public Integer getIdTest() {
		return idTest;
	}
	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
