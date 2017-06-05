package com.ensa.gestionPharmacie.controller;



import java.util.HashSet;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Client;
import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.service.AdminService;
import com.ensa.gestionPharmacie.service.ClientService;
import com.ensa.gestionPharmacie.service.MedicamentService;

@Controller
public class PanierController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private MedicamentService medicamentService;

	
	/*@RequestMapping(value="/info",method = RequestMethod.GET)
	public ModelAndView go(){
		ModelAndView model=new ModelAndView("go-to-panier");
		List<String> list=new ArrayList<String>();
		return model;
	}*/
	@RequestMapping(value="/monPanier",method = RequestMethod.GET)
	public ModelAndView panier(HttpServletRequest req){
		Client client=new Client();
		HttpSession session =req.getSession(); 
		Set<Medicament> medicaments= new HashSet<Medicament>() ;
		Medicament medicament=new Medicament();
		@SuppressWarnings("unchecked")
		Set<String> idMeds=(Set<String>)session.getAttribute("idMeds") ;
		
		Iterator<String> med = idMeds.iterator();
	    while(med.hasNext()){
	    	medicament=medicamentService.getMedicament(med.next());
	    	medicaments.add(medicament);
	    	}
	    session.setAttribute("medicaments", medicaments);
		return new ModelAndView("panier","command",client);
		
	}
	@RequestMapping(value="/annuler") //!!!!!!!
	public ModelAndView annuler(@RequestParam("nom") String nomM,HttpServletRequest req){
		ModelAndView model =new ModelAndView();
		HttpSession session =req.getSession();
		@SuppressWarnings("unchecked")
		Set<String> idMeds=(Set<String>)session.getAttribute("idMeds") ;
			
		idMeds.remove(nomM);
		
		model.setViewName("redirect:/monPanier");

		return model;
	}
	@RequestMapping(value="/ajouterClient",method = RequestMethod.POST)
	public ModelAndView AjouterClient(@ModelAttribute("client")Client client){
		
		clientService.ajouterClient(client);
		return new ModelAndView("infos");
		
	}
	@RequestMapping(value="/distance",method = RequestMethod.GET)
	public ModelAndView distance(){
		
		return new ModelAndView("distance");
		
	}
	
	/*@RequestMapping(value="/coordonnees",method = RequestMethod.POST)
	public @ResponseBody List<Pharmacie> coordonnes(){
		
		list
		return new ModelAndView("infos");
		
	}*/
	
	
	//////////////////////////////////////
	public ClientService getClientService() {
		return clientService;
	}
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

}
