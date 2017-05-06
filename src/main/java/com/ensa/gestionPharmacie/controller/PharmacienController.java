package com.ensa.gestionPharmacie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PharmacienController {
	
	@RequestMapping("/pharmacien")
	public ModelAndView login(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("pharmacien-login");
		 return model;
	}

}
