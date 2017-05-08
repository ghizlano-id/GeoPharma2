package com.ensa.gestionPharmacie.service;

import java.util.List;

import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Pharmacien;
import com.ensa.gestionPharmacie.entity.Test;
import com.ensa.gestionPharmacie.entity.TestFils;

public interface TestService {

	List<Test> getAllTest();
	List<Admin> getAllAdmins();
	List<Pharmacien> getAllPharmaciens();
	void add(TestFils ts);
	void addP(Admin a);
	void addPh(Pharmacien p);

}
