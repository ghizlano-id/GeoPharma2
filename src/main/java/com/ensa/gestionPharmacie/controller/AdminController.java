package com.ensa.gestionPharmacie.controller;


import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacien;
import com.ensa.gestionPharmacie.service.AdminService;
import com.ensa.gestionPharmacie.service.PharmacieService;
import com.ensa.gestionPharmacie.service.PharmacienService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;







@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private PharmacienService pharmacienService;
	@Autowired
	private PharmacieService pharmacieService;



	//-------------------------------------------------------
	@RequestMapping(value="/admin",method = RequestMethod.GET)
	public ModelAndView login(){
		//ModelAndView model=new ModelAndView();
		return new ModelAndView("admin-login","command",new Admin());
	}

	@RequestMapping(value="/PageAcceuilAdmin",method = RequestMethod.POST)  
	public ModelAndView save(@ModelAttribute("admin") Admin admin){  
		ModelAndView model=new ModelAndView();
		if(adminService.estAdmin(admin.getEmail(), admin.getPassword()))
			model.setViewName("admin-acceuil");
		else
			model.setViewName("redirect:/admin");
		return model;
	}

	//-----------------------Ajout pharmacien/pharmacie-----------------------
	@RequestMapping(value="/ajout-pharmacien",method=RequestMethod.GET)
	public ModelAndView ajout1(){
		
		Pharmacien pharmacien=new Pharmacien();
		
		return new ModelAndView("ajout-pharmacien","command",pharmacien);
	}

	@RequestMapping(value="/ajouter1",method = RequestMethod.POST)
	public ModelAndView ajoutPharmacien(@ModelAttribute("pharmacien")Pharmacien pharmacien){

		pharmacienService.ajouter(pharmacien);

		Pharmacie pharmacie=new Pharmacie();
		String CIN=pharmacien.getCIN();

		System.out.println(pharmacien.getCIN());

		return new ModelAndView("redirect:/ajout-pharmacie/"+CIN,"command",pharmacie);
	}
	
	//--------------------------------------------------------
	@RequestMapping(value="/ajout-pharmacie/{CIN}",method=RequestMethod.GET)
	public ModelAndView ajout2(@PathVariable("CIN") String CIN,RedirectAttributes redirectAttrs){

		Pharmacie pharmacie=new Pharmacie();
		ModelAndView model=new  ModelAndView("ajout-pharmacie","command",pharmacie);
		model.addObject("cin", CIN);

		return model;
	}


	@RequestMapping(value="/ajouter2",method = RequestMethod.POST)
	public ModelAndView ajoutPharmacie(@ModelAttribute("pharmacie") Pharmacie pharmacie,@RequestParam("cinAttrribute") String CIN){

		ModelAndView model=new ModelAndView();
		pharmacie.setPharmacien(pharmacienService.getPharmacien(CIN));
		pharmacieService.ajouter(pharmacie);
		System.out.println(CIN);

		model.setViewName("redirect:/pharmacien_acceuil");

		return model;
	}

	//----------------Getters and setters (for injection)------------------
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public PharmacienService getPharmacienService() {
		return pharmacienService;
	}
	public void setPharmacienService(PharmacienService pharmacienService) {
		this.pharmacienService = pharmacienService;
	}

}
