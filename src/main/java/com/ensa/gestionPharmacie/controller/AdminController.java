
package com.ensa.gestionPharmacie.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacien;
import com.ensa.gestionPharmacie.service.AdminService;
import com.ensa.gestionPharmacie.service.PharmacieService;
import com.ensa.gestionPharmacie.service.PharmacienService;

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

		model.addObject("pharmacie", pharmacie);
		model.setViewName("infos");

		return model;
	}
	@RequestMapping(value="/infos")
	public ModelAndView affiche(){
		ModelAndView model=new ModelAndView();
		model.setViewName("infos");

		return model;

	}
	//---------------------Supprimer une pharmacie-----------------
	@RequestMapping(value="/supprimer-pharmacie")
	public ModelAndView supprimer(){
		ModelAndView model =new ModelAndView();
		List<Pharmacie> allpharmacie=pharmacieService.allPharmacie();
		model.addObject("pharmacies", allpharmacie);
		model.setViewName("supprimer-pharmacie");

		return model;
	}
	@RequestMapping(value="/suppression")
	public ModelAndView supprimer(int idPharma,String CIN){
		ModelAndView model =new ModelAndView();
		pharmacieService.supprimer(idPharma);
		pharmacienService.supprimer(CIN);
		model.setViewName("redirect:/supprimer-pharmacie");

		return model;
	}
	//----------------Phrmacie de garde-----------
	@RequestMapping(value="/pharmacies-de-garde")
	public ModelAndView afficher(){
		
		ModelAndView model=new ModelAndView();
		model.setViewName("map");

		return model;

	}

	
	@RequestMapping(value="/pharmacies-garde",method = RequestMethod.GET)
	public  @ResponseBody List<Pharmacie> getPharmacies(HttpServletRequest request, HttpServletResponse response){

		List<Pharmacie> list=pharmacieService.allPharmacie();

		return list;
		/*Pharmacien pharmacien=new Pharmacien();
			pharmacien.setCIN("EE543");
			pharmacien.setEmail("ghizo@mail.com");
			pharmacien.setNom("ghizo");
			pharmacien.setPassword("aaa");
			
			return pharmacien;*/

	}

	
	
	
	//----------------Toutes les Phrmacies-----------
		@RequestMapping(value="/pharmacies")
		public ModelAndView afficher2(){
			
			ModelAndView model=new ModelAndView();
			model.setViewName("allph-map");

			return model;

		}

		
		@RequestMapping(value="/pharmacies-all",method = RequestMethod.GET)
		public  @ResponseBody List<Pharmacie> getPharmacies2(HttpServletRequest request, HttpServletResponse response){

			List<Pharmacie> list=pharmacieService.allPharmacie();

			return list;
			

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
	public PharmacieService getPharmacieService() {
		return pharmacieService;
	}

	public void setPharmacieService(PharmacieService pharmacieService) {
		this.pharmacieService = pharmacieService;
	}
}
