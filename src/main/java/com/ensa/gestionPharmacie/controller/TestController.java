package com.ensa.gestionPharmacie.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacien;
import com.ensa.gestionPharmacie.entity.Test;
import com.ensa.gestionPharmacie.entity.TestFils;

import com.ensa.gestionPharmacie.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService TestService;


	
	@RequestMapping("/")
	public ModelAndView index(){
		
		ModelAndView model =new ModelAndView();
		
		List<Test> allTest = TestService.getAllTest();
		model.addObject("allTest", allTest);
		
		/*List<Admin> allAdmin = TestService.getAllAdmins();
		model.addObject("allAdmin", allAdmin);
		for(int i=0;i<allAdmin.size();i++)
			System.out.println(allAdmin.get(i));*/
		
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping("/add")
	public ModelAndView index2(){
		
		ModelAndView model =new ModelAndView();
		
		TestFils test=new TestFils();
		test.setName("zineb");
		test.setNickname("zin");
		TestService.add(test);
		//------------Admin------------
		Admin admin=new Admin();
		admin.setCIN("EE556677");
		admin.setEmail("ghizlane.id@gmail.com");
		admin.setNom("el idrissi");
		admin.setPrenom("ghizlane");
		admin.setTel("0699196616");
		admin.setPassword("aaa");
		TestService.addP(admin);
		//------------Pharmacien---------------
		
		Pharmacien ph= new Pharmacien() ; 
		ph.setCIN("EE722745");
		ph.setEmail("nassi@luv2eat.com");
		ph.setNom("Barakat");
		ph.setPrenom("Nassima");
		ph.setPassword("toto");
		ph.setTel("06701487");
		TestService.addPh(ph);
 	

		TestService.addP(admin);

		
		model.setViewName("index");
		
		return model;
	}
	
}
