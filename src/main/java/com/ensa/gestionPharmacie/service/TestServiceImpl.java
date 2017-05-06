package com.ensa.gestionPharmacie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.TestDao;
import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Test;
import com.ensa.gestionPharmacie.entity.TestFils;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDao testDao;
	
	public List<Test> getAllTest() {

		return testDao.getAllTest();
	}
	public List<Admin> getAllAdmins() {

		return testDao.getAllAdmins();
	}
	public void add(TestFils tf){
		testDao.add(tf);
		
	}
	public void addP(Admin a){
		testDao.addP(a);
		
	}
	
	
/////////////////////////////////////////
	public TestDao getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	
}
