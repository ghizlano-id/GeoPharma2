package com.ensa.gestionPharmacie.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Client;
import com.ensa.gestionPharmacie.entity.Commande;
import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.service.ClientService;
import com.ensa.gestionPharmacie.service.CommandeService;
import com.ensa.gestionPharmacie.service.MedicamentService;
import com.ensa.gestionPharmacie.service.Pharmacie_medicamentService;



@Controller
public class ClientController {

	@Autowired
	private MedicamentService medicamentService ; 
	@Autowired
	private ClientService clientService;
	@Autowired
	private CommandeService commandeServie;
	@Autowired
	private Pharmacie_medicamentService PharmacieMedicamentService;


	public Pharmacie_medicamentService getPharmacieMedicamentService() {
		return PharmacieMedicamentService;
	}
	public void setPharmacieMedicamentService(Pharmacie_medicamentService pharmacieMedicamentService) {
		PharmacieMedicamentService = pharmacieMedicamentService;
	}
	public MedicamentService getMedicamentService() {
		return medicamentService;
	}
	public void setMedicamentService(MedicamentService medicamentService) {
		this.medicamentService = medicamentService;
	}
	public ClientService getClientService() {
		return clientService;
	}
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
	
	
	
	/* *********page boostrap (ghizlane)********************* */
	@RequestMapping(value="/")
	public ModelAndView acceuil(HttpServletRequest request){
		getSession(request);
		return new ModelAndView("PageAcceuil");
	}
	//page de commande
		@RequestMapping("/monPanier2")
		public ModelAndView panier2(HttpServletRequest request){
			getSession(request);
			
			///pharmacie plus proches
			HttpSession session =request.getSession(true);
			List<Pharmacie> prochesPharmacies=new ArrayList<Pharmacie>();//***
			session.setAttribute("prochesPharmacies",prochesPharmacies);
			
			Client client=new Client();
			ModelAndView model=new ModelAndView("monPanier","command",client);
			 
			return model;
		}
	// page liste medicaments (boostrap)
		@RequestMapping("/listeMedicaments")
		public ModelAndView afficher(HttpServletRequest request){
			getSession(request);
			ModelAndView model=new ModelAndView("listeProduits");
			Set<Medicament> medicaments=medicamentService.AllMedicamentDisp();  	
			model.addObject("listemedicament",medicaments) ;
			return model;
			
		}
	 // ajouter au panier
		@RequestMapping(value="/ajoutPanier/{id}",method = RequestMethod.POST) //2
		public void ajoutAuPanier(@PathVariable("id") String id ,HttpServletRequest req){
			
			HttpSession session =req.getSession(); 
			@SuppressWarnings("unchecked")
			List<String> idMeds=(List<String>)session.getAttribute("idMeds") ;
			 if(!idMeds.contains(id))
				idMeds.add(id) ;
				
			
		}
	 //La liste des commandes
		@RequestMapping(value="/cmd",method = RequestMethod.POST) 
		public @ResponseBody List<Medicament> panier(HttpServletRequest request){
			
			HttpSession session =request.getSession();
			List<Medicament> medicaments= new ArrayList<Medicament>() ;
			Medicament medicament=new Medicament();
			
			@SuppressWarnings("unchecked")
			List<String> idMeds=(List<String>)session.getAttribute("idMeds") ;
			
			ListIterator<String> med = idMeds.listIterator();
		    while(med.hasNext()){
		    	medicament=medicamentService.getMedicament(med.next());
		    	medicaments.add(medicament);
		    	}
				
				
				return medicaments;
			
		}
		
    //  annuler commande
		@RequestMapping(value="/annuler") 
		public ModelAndView annuler(@RequestParam("nom") String nomM,HttpServletRequest request){
			
			HttpSession session =request.getSession();
			@SuppressWarnings("unchecked")
			List<String> idMeds=(List<String>)session.getAttribute("idMeds") ;
			
			idMeds.remove(nomM);

			return new ModelAndView("redirect:/monPanier2");
			
		}
	// Verifier la confirmation des commandes
		@RequestMapping(value="/verifier",method = RequestMethod.POST)
		public  @ResponseBody int verifier(HttpServletRequest request){
			int n=1;
			HttpSession session=request.getSession();
			@SuppressWarnings("unchecked")
			List<Pharmacie> prochesPharmacies=(List<Pharmacie>) session.getAttribute("prochesPharmacies");
			@SuppressWarnings("unchecked")
			List<String> idMeds = (List<String>)session.getAttribute("idMeds");
			
			if(idMeds.size()==0|| prochesPharmacies.size()==0){
				n=0;
			}
			return n;
			
		} // ?????????????
		//****ajouter les commandes*********
		@RequestMapping(value="/ajouter",method = RequestMethod.POST)
		public ModelAndView AjouterCommande(@ModelAttribute("client")Client client,double x,double y,HttpServletRequest request){
			ModelAndView model=new ModelAndView();
			
			HttpSession session=request.getSession();
			@SuppressWarnings("unchecked")
			List<Pharmacie> prochesPharmacies=(List<Pharmacie>) session.getAttribute("prochesPharmacies");
			@SuppressWarnings("unchecked")
			List<String> idMeds = (List<String>)session.getAttribute("idMeds");
			
			if(idMeds.size()==0){
				model=new ModelAndView("monPanier","command",client);
				model.addObject("erreur","le panier est vide");
				return model;
			}
			else if(idMeds.size()!=prochesPharmacies.size()){
				model=new ModelAndView("monPanier","command",client);
				model.addObject("erreur","Veuillez confirmer tous les médicaments ajoutés au panier");
				return model;
			}
				
			else{
			Medicament medicament=new Medicament();
			List<Medicament> medicaments= new ArrayList<Medicament>() ;
			
			//Récuperer la liste des medicament depuis la base via idMeds*
			ListIterator<String> med1 = idMeds.listIterator();
		    while(med1.hasNext()){
		    	medicament=medicamentService.getMedicament(med1.next());
		    	medicaments.add(medicament);
		    	}
		    
			Commande commande =new Commande();

			
			///Ajouter Client
					clientService.ajouterClient(client);
			///ajouter les commandes
			 ListIterator<Medicament> med2 = medicaments.listIterator();
			 ListIterator<Pharmacie> pharm = prochesPharmacies.listIterator();
			
			 while(med2.hasNext()){
					commande.setClient(client);
					commande.setLongitude(y);
					commande.setLaltitude(x);
					commande.setQuantite(1);
					commande.setMedicament(med2.next());
					commande.setPharmacie(pharm.next());
					commande.setDateTime(new Date());
				    commandeServie.ajouter(commande);
				    //PharmacieMedicamentService.updateQantite(med2.next().getNom(), pharm.next().getIdPharma());
				}
			 ListIterator<Medicament> med3 = medicaments.listIterator();
			 ListIterator<Pharmacie> pharm3 = prochesPharmacies.listIterator();
			 while(med3.hasNext()){
				    PharmacieMedicamentService.updateQantite(med3.next().getNom(), pharm3.next().getIdPharma());
				}
			 
			 session.setAttribute("idMeds", null);
			 session.setAttribute("prochesPharmacies", null);
			  
			  model.setViewName("PageAcceuil");
			 
					return model;
			}
		}
		// Pharmacies de garde
		@RequestMapping(value="/PharmaciesGarde")
		public ModelAndView pharmacices(){
			return new  ModelAndView("pharmacies-garde") ;
		}
		// Chercher un medicment
		@RequestMapping(value="/chercherMedicament")
		public ModelAndView medicamentsDisp(){
			ModelAndView model=new  ModelAndView("chercher-medicament");
			List<Medicament> list=medicamentService.All() ;
			model.addObject("medicaments", list);
			
			return  model;
		}
		
		
		
		//-------------fonction to initialize session (list:idMeds)---------------
		public void getSession(HttpServletRequest request){
			HttpSession session =request.getSession(true); 
			@SuppressWarnings("unchecked")
			List<String> idMeds=(List<String>)session.getAttribute("idMeds") ;
				if(idMeds==null){
					idMeds= new ArrayList<String>() ; 
					session.setAttribute("idMeds", idMeds);
				}
		}
	/* ****************************** */
		
	
		
		
	//**********ancien code***************
	@RequestMapping(value="/acceuil")
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
