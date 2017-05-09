package com.ensa.gestionPharmacie.controller;


import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacien;
import com.ensa.gestionPharmacie.service.AdminService;
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
	//-------------------------------------------------------
	@RequestMapping(value="/admin",method = RequestMethod.GET)
	public ModelAndView login(){
		//ModelAndView model=new ModelAndView();
		 return new ModelAndView("admin-login","command",new Admin());
	}
	
	@RequestMapping(value="/PageAcceuilAdmin",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("admin") Admin admin){  
		ModelAndView model=new ModelAndView();
		//System.out.println(admin.getEmail()+" "+admin.getPassword());
		if(adminService.estAdmin(admin.getEmail(), admin.getPassword()))
			model.setViewName("admin-acceuil");
		else
			model.setViewName("index");
			return model;
	}
	
	//////////////////////////Ajout pharmacien/pharmacie////////////////////////////////
	@RequestMapping(value="/ajout-pharmacien",method=RequestMethod.GET)
	public ModelAndView ajout1(){
		//ModelAndView model=new ModelAndView();
		Pharmacien pharmacien=new Pharmacien();
		// model.setViewName("ajout-pharmacien");

		  //return model;
				return new ModelAndView("ajout-pharmacien","command",pharmacien);
	}
	
    @RequestMapping(value="/ajouter1",method = RequestMethod.POST)
    public ModelAndView ajoutPharmacien(@ModelAttribute("pharmacien")Pharmacien pharmacien){
    	//ModelAndView model=new ModelAndView();
    	
    	 pharmacienService.ajouter(pharmacien);
    	 
    	 Pharmacie pharmacie=new Pharmacie();
    	 System.out.println(pharmacien.getCIN());
    	 String CIN=pharmacien.getCIN();
    	 
    	 	
    	return new ModelAndView("redirect:/ajout-pharmacie/"+CIN,"command",pharmacie);
    }
    //--------------------------------------------------------
    @RequestMapping(value="/ajout-pharmacie/{CIN}",method=RequestMethod.GET)
	public ModelAndView ajout2(@PathVariable("CIN") String CIN){
		//ModelAndView model=new ModelAndView();
		Pharmacie pharmacie=new Pharmacie();
				 return new ModelAndView("ajout-pharmacie","command",pharmacie);
	}
	
    @RequestMapping(value="/ajouter2",method = RequestMethod.POST)
    public ModelAndView ajoutPharmacie(@ModelAttribute("pharmacie")Pharmacie pharmacie,@RequestParam("var") String var){
    	ModelAndView model=new ModelAndView();
    	
    	// pharmacienService.ajouter(pharmacie);
    	//System.out.println(pharmacien.getCIN());
    	System.out.println(var);
    	model.setViewName("redirect:/ajout-pharmacie/");
    	return model;
    }

	

}
