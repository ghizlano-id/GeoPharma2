package com.ensa.gestionPharmacie.controller;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.ensa.gestionPharmacie.dao.Pharmacie_medicamentDao;
import com.ensa.gestionPharmacie.entity.Client;
import com.ensa.gestionPharmacie.entity.Commande;
import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;
import com.ensa.gestionPharmacie.service.AdminService;
import com.ensa.gestionPharmacie.service.ClientService;
import com.ensa.gestionPharmacie.service.CommandeService;
import com.ensa.gestionPharmacie.service.MedicamentService;
import com.ensa.gestionPharmacie.service.PharmacieService;

@Controller
public class PanierController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private MedicamentService medicamentService;
	@Autowired
	private PharmacieService pharmacieService;
	@Autowired
	private Pharmacie_medicamentDao pmDao;
	@Autowired
	private CommandeService commandeServie;

	
	/*@RequestMapping(value="/info",method = RequestMethod.GET)
	public ModelAndView go(){
		ModelAndView model=new ModelAndView("go-to-panier");
		List<String> list=new ArrayList<String>();
		return model;
	}*/
	@RequestMapping(value="/monPanier",method = RequestMethod.GET)
	public ModelAndView panier(HttpServletRequest req){
		
		
		Client client=new Client();
		ModelAndView model=new ModelAndView("panier","command",client);
		HttpSession session =req.getSession(); 
		Set<Medicament> medicaments= new HashSet<Medicament>() ;
		Medicament medicament=new Medicament();
		//Liste de pharmacie les plus proches ????
		List<Pharmacie> prochesPharmacies=new ArrayList<Pharmacie>();//***
		//model.addObject("prochesPharmacies",prochesPharmacies);//*********
		session.setAttribute("prochesPharmacies",prochesPharmacies);
		//Récuperer la liste des medicament ajoutés au panier
		@SuppressWarnings("unchecked")
		Set<String> idMeds=(Set<String>)session.getAttribute("idMeds") ;
		//Récuperer la liste des medicament depuis la base via idMeds*
		Iterator<String> med = idMeds.iterator();
	    while(med.hasNext()){
	    	medicament=medicamentService.getMedicament(med.next());
	    	medicaments.add(medicament);
	    	}
	    session.setAttribute("medicaments", medicaments);
	    
		return model;
		
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
	public ModelAndView AjouterClient(@ModelAttribute("client")Client client,HttpServletRequest req){
		
		HttpSession session=req.getSession();
		@SuppressWarnings("unchecked")
		List<Pharmacie> prochesPharmacies=(List<Pharmacie>) session.getAttribute("prochesPharmacies");
		@SuppressWarnings("unchecked")
		Set<Medicament> medicaments = (Set<Medicament>)session.getAttribute("medicaments");
	    
		Commande commande =new Commande();
		
		//Ajouter Client
		clientService.ajouterClient(client);
		
		int i=0;
		Iterator<Medicament> med = medicaments.iterator();
	    while(med.hasNext()){
			commande.setClient(client);
			commande.setQuantite(1);
			commande.setMedicament(med.next());
			commande.setPharmacie(prochesPharmacies.get(i));
			//Ajouter commande
		    commandeServie.ajouter(commande);
			i++;
		}
	    
		return new ModelAndView("infos");
		
	}
	
	@RequestMapping(value="/distance",method = RequestMethod.GET)
	public ModelAndView distance(){
		
		return new ModelAndView("distance");
		
	}
	//***********Verifier l'affichage de list of Pharmacie_medicament
	@RequestMapping(value="/pharmacies-madicament/{idMedica}",method = RequestMethod.GET)
	public  @ResponseBody List<Pharmacie> getPharmacies(@PathVariable("idMedica") String idMedica,HttpServletRequest request, HttpServletResponse response){
		
		//String idMedica
		List<Pharmacie_medicament> list=pmDao.getPharmacies_medicament(idMedica);

		List<Pharmacie> listPharmacie=pharmacieService.getPharmacies(list);
		return listPharmacie;
	}
	@RequestMapping(value="/ajoutPharmacieProche",method = RequestMethod.POST) //2
	public void login(@RequestParam("lato") Double x ,@RequestParam("lngo") Double y,HttpServletRequest req){
		
		Pharmacie pharmacie=pharmacieService.getPharmacie((double)x,(double)y);
		HttpSession session =req.getSession();
		@SuppressWarnings("unchecked")
		List<Pharmacie> prochesPharmacies=(List<Pharmacie>)session.getAttribute("prochesPharmacies") ;
		prochesPharmacies.add(pharmacie) ;
		Iterator<Pharmacie> med = prochesPharmacies.iterator();
	    while(med.hasNext()){
	    	System.out.println(med.next().getName());
	    	}
    	System.out.println("*************");

		System.out.println(x+" "+y);
		
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
