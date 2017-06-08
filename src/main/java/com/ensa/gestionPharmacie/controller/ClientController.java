package com.ensa.gestionPharmacie.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;
import com.ensa.gestionPharmacie.service.MedicamentService;

@Controller
public class ClientController {

	@Autowired
	private MedicamentService medicamentService ; 



	@RequestMapping("/acceuil")
	public ModelAndView login2(HttpServletRequest req){
		ModelAndView model=new ModelAndView();
		model.setViewName("acceuil");
		//Create session   --------------->
				HttpSession session =req.getSession(true); 
				Set<String> idMeds= new HashSet<String>() ; 
				session.setAttribute("idMeds", idMeds); //<--------------------
		return model;
	}

	
	@RequestMapping("/commander")  //1
	public ModelAndView login(HttpServletRequest req){ //??id
		ModelAndView model=new ModelAndView();
		model.setViewName("commande");
		//Get all medicament that are available
		List<Medicament> l=medicamentService.All() ;  	
		model.addObject("listmed", l) ;
		//Create session
		/*HttpSession session =req.getSession(true); 
		Set<String> idMeds= new HashSet<String>() ; 
		session.setAttribute("idMeds", idMeds);*/
		return model;
	}
	@RequestMapping(value="/ajoutPanier/{id}",method = RequestMethod.POST) //2
	public void login(@PathVariable("id") String id ,HttpServletRequest req){
		
		HttpSession session =req.getSession(); 
		@SuppressWarnings("unchecked")
		Set<String> idMeds=(Set<String>)session.getAttribute("idMeds") ;
			idMeds.add(id) ;
		
	}

	
	
	
	/*@RequestMapping("/commander/{id}") !!!!2
	public ModelAndView login(@PathVariable("id") String id ,HttpServletRequest req){ //??id
		ModelAndView model=new ModelAndView();
		
		HttpSession session =req.getSession(); 
		@SuppressWarnings("unchecked")
		Set<String> idMeds=(Set<String>)session.getAttribute("idMeds") ;
			idMeds.add(id) ;
		
			model.setViewName("redirect:/commander");
		return model;
	}*/
	
	
	/*@RequestMapping("/commander/{id}")  
	public ModelAndView login(@PathVariable("id") String id,HttpServletRequest req){ //??id
		ModelAndView model=new ModelAndView();
		boolean t=true ; 
		model.setViewName("commande");
		//Get all medicament that are available
		List<Medicament> l=medicamentService.All() ;  	
		model.addObject("listmed", l) ;
		//Create session
		HttpSession session =req.getSession(t); 
		if(id==null){
			Set<String> idMeds= new HashSet<String>() ; 
			session.setAttribute("idMeds", idMeds);}
		else{
			@SuppressWarnings("unchecked")
			Set<String> idMeds=(Set<String>)session.getAttribute("idMeds") ; 

			idMeds.add(id) ; 
			//session.setAttribute("idMeds", idMeds);
		}

		return model;
	}

	//Ghizlane
	/*@RequestMapping("/getpanier")
	public ModelAndView login(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("infos");
		 return model;
	}*/



}
