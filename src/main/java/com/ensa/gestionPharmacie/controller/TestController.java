package com.ensa.gestionPharmacie.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacien;
import com.ensa.gestionPharmacie.entity.TestFils;
import com.ensa.gestionPharmacie.service.MedicamentService;
import com.ensa.gestionPharmacie.service.TestService;


@Controller
public class TestController {

	@Autowired
	private TestService testService;
	@Autowired
	private MedicamentService ms;


	
	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	public MedicamentService getMs() {
		return ms;
	}

	public void setMs(MedicamentService ms) {
		this.ms = ms;
	}

	@RequestMapping("/add")
	public ModelAndView index2(){
		
		ModelAndView model =new ModelAndView();
		
		TestFils test=new TestFils();
		test.setName("zineb");
		test.setNickname("zin");
		testService.add(test);
		//------------Admin------------
		Admin admin=new Admin();
		admin.setCIN("EE556677");
		admin.setEmail("ghizlane.id@gmail.com");
		admin.setNom("el idrissi");
		admin.setPrenom("ghizlane");
		admin.setTel("0699196616");
		admin.setPassword("aaa");
		testService.addP(admin);
		//------------Pharmacien---------------
		
		Pharmacien ph= new Pharmacien() ; 
		ph.setCIN("EE722745");
		ph.setEmail("nassi@luv2eat.com");
		ph.setNom("Barakat");
		ph.setPrenom("Nassima");
		ph.setPassword("toto");
		ph.setTel("06701487");
		testService.addPh(ph);
 	

		testService.addP(admin);

		
		model.setViewName("index");
		
		return model;
	}
	
	@RequestMapping("/dispo")
	public @ResponseBody Set<Medicament> afficher(){
		Set<Medicament> medica=ms.AllMedicamentDisp();
		for(Medicament med:medica)
			System.out.println(med.getNom()); 
		return medica;
	}
	
}
