package com.ensa.gestionPharmacie.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionPharmacie.dao.AdminDao;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	//---------------Getters and setters------------
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	//--------------Fonctions--------------
	public boolean estAdmin(String email, String password) {
		return adminDao.estAdmin(email, password);
	}
	

}
