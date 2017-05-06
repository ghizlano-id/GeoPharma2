package com.ensa.gestionPharmacie.entity;

import javax.persistence.Entity;

@Entity
public class TestFils  extends Test{
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
