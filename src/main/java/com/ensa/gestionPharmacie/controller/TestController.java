package com.ensa.gestionPharmacie.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Admin;
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
		admin.setCIN("EE112233");
		admin.setEmail("ghizo.com");
		admin.setNom("id");
		admin.setPrenom("ghizo");
		admin.setTel("061234");
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
 	
		
		model.setViewName("index");
		
		return model;
	}
}
