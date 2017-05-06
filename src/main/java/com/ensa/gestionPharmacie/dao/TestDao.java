package com.ensa.gestionPharmacie.dao;

import java.util.List;


import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Test;
import com.ensa.gestionPharmacie.entity.TestFils;

public interface TestDao {

	List<Test> getAllTest();
	List<Admin> getAllAdmins();
	void add(TestFils ts);
	void addP(Admin a);
}
