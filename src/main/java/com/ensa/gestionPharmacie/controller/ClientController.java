package com.ensa.gestionPharmacie.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;
import com.ensa.gestionPharmacie.service.MedicamentService;

@Controller
public class ClientController {

	@Autowired
	 private MedicamentService medicamentService ; 
	
	
	
	@RequestMapping("/acceuil")
	public ModelAndView login2(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("acceuil");
		 return model;
	}
	
	
	@RequestMapping("/commander")
	public ModelAndView login(String id,HttpServletRequest req){
		ModelAndView model=new ModelAndView();
		  boolean t=true ; 
		 	model.setViewName("commande");
		List<Medicament> l=medicamentService.All() ;  	
		model.addObject("listmed", l) ;
		HttpSession session =req.getSession(); 
		if(id==null){
		Set<String> idMeds= new HashSet<String>() ; 
		session.setAttribute("idMeds", idMeds);}
		else{
			Set<String> idMeds=(Set<String>)session.getAttribute("idMeds") ; 
		
			idMeds.add(id) ; 
			session.setAttribute("idMeds", idMeds);
			
			
		}
		
		 return model;
	}


	@RequestMapping("/getpanier")
	public ModelAndView login(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("infos");
		 return model;
	}
	

	
	
}
