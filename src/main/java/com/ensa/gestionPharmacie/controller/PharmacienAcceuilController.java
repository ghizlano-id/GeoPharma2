package com.ensa.gestionPharmacie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PharmacienAcceuilController {
	
	@RequestMapping("/pharmacien_acceuil")
	public ModelAndView login(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("pharmacien-acceuil");
		 return model;
	}

}
