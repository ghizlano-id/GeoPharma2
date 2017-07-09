package com.ensa.gestionPharmacie.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

import com.ensa.gestionPharmacie.entity.Client;
import com.ensa.gestionPharmacie.entity.Commande;
import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;
import com.ensa.gestionPharmacie.entity.Pharmacien;
import com.ensa.gestionPharmacie.service.CommandeService;
import com.ensa.gestionPharmacie.service.MedicamentService;
import com.ensa.gestionPharmacie.service.PharmacieService;
import com.ensa.gestionPharmacie.service.Pharmacie_medicamentService;
import com.ensa.gestionPharmacie.service.PharmacienService;






@Controller
public class PharmacienController {
	
	@Autowired
	private  PharmacienService pharmacienService; 
	@Autowired
	private  CommandeService commandeService; 
	
	@Autowired
	private  Pharmacie_medicamentService pmd; 
	
	@Autowired
	 private MedicamentService medicamentService ; 
	
	@Autowired
	private PharmacieService pharmacieService ; 
	
  //------------------getters & setters ---------------


	public PharmacienService getPharmacienService() {
		return pharmacienService;
	}



	public MedicamentService getMedicamentService() {
		return medicamentService;
	}



	public void setMedicamentService(MedicamentService medicamentService) {
		this.medicamentService = medicamentService;
	}



	public PharmacieService getPharmacieService() {
		return pharmacieService;
	}



	public void setPharmacieService(PharmacieService pharmacieService) {
		this.pharmacieService = pharmacieService;
	}



	public void setPharmacienService(PharmacienService pharmacienService) {
		this.pharmacienService = pharmacienService;
	}

	

	
	



	public CommandeService getCommandeService() {
		return commandeService;
	}



	public void setCommandeService(CommandeService commandeService) {
		this.commandeService = commandeService;
	}



	public Pharmacie_medicamentService getPmd() {
		return pmd;
	}



	public void setPmd(Pharmacie_medicamentService pmd) {
		this.pmd = pmd;
	}



	@RequestMapping("/pharmacien_acceuil")
	public ModelAndView login2(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("pharmacien-acceuil");
		 return model;
	}
    /// affihcer l itineraire entre deux point .... juste pour le teste
	@RequestMapping("/test3")
	public ModelAndView log2(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("test3");
		 return model;
	}
	@RequestMapping("/livraison")
	public ModelAndView l2(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("livraison-pharmacien");
		 return model;
	}

	
	// celui la est le meme que test1 qui afficher l itinaire de la livraison mais avec les valeur des distance 
	@RequestMapping("/test")
	public ModelAndView lo2(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("test3");
		 return model;
	}

	@RequestMapping("/loginph")
	public ModelAndView loginph(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("pharmacien-acceuil");
		 return model;
	}

	/*
	@RequestMapping(value = "/test")
	public String someMethod(@RequestParam(value="login", required=false) String l ,@RequestParam(value="pwd", required=false) String p,Model model) {
	 //do stuff with valueOne variable here
	
		model.addAttribute("log", l);
		model.addAttribute("pass", p);
		
	 return "index" ; 
	
	
	public ModelAndView fileupload(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map modelMap = new HashMap();
		modelMap.put(name,request.getParameter("uname")); 
		
		modelView.addAllObjects(modelMap); 
		modelView.setViewName("salu.jsp");
	}
		
	
	
	
@RequestMapping(value = "/registrer",method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
	String m="index" ; 
	User userForm = new User();
	model.put("userForm", userForm);
	return m;
	
	@RequestMapping(value="/login", method= { RequestMethod.GET } )
	public String redirect(@ModelAttribute("User") User user,  BindingResult bindingResult, Model model)  {
	  

	    model.addAttribute("name", user.getLogin());
	    
	    return "index";
	}
	
	
	*/
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("pharmacien") Pharmacien pharmacien, HttpServletRequest req)
    {   
		ModelAndView model=new ModelAndView();
		String id=pharmacienService.estPharmacien(pharmacien.getEmail(), pharmacien.getPassword()) ;
		int pharmacie_id=0 ;
		HttpSession session = req.getSession()   ;
		session.setAttribute("listcommande",null);
		session.setAttribute("listAll",null);
		session.setAttribute("lpm",null);
      if(id!="empty")
        
      {   
                
    	  pharmacie_id=pharmacieService.getId(id) ;
    	  Pharmacie ph=pharmacieService.getById(pharmacie_id) ; 
    	//  System.out.println(ph.getName());
    	  //  System.out.println(pharmacie_id);
    	   session.setAttribute("ph", ph);
    	   
    	  
    	  model.addObject("id", pharmacie_id) ; 
	 	model.setViewName("pharmacien-acceuil");
    	  
    	  }
      
      else 
      {    
    	  model.addObject("erreur", "email ou mot de pass invalid");
		model.setViewName("redirect:/pharmacien"); }
      
      return model ;
	   
    }
	
	@RequestMapping(value="/pharmacien",method=RequestMethod.GET)
	public ModelAndView login(@RequestParam(value="erreur",required=false) String erreur){
		ModelAndView model=new ModelAndView("pharmacien-login","command",new Pharmacien());
		if(erreur!=null && !erreur.equals("") ){
			model.addObject("erreur", erreur);
		}
		 return model;
	}
	

	//----------------------Ajouter medicament-----------------------
  /*	
   * 
   * si on utilise pas la session
	@RequestMapping(value="/ajouter/{id}", method=RequestMethod.POST)
    public ModelAndView login4(@PathVariable("id") int id,@ModelAttribute("Pharmacie_medicament") Pharmacie_medicament pharmacie_medicament) //,@ModelAttribute("Pharmacie") Pharmacie pharmacies
    {   
		Pharmacie p= new Pharmacie() ; 
		p.setIdPharma(id);
		
		pharmacie_medicament.setPharmacie(p);
	
		int i=pmd.Ajouter(pharmacie_medicament);
		if(i==1)
		{   System.out.println("ok");
	   return new ModelAndView("index"); }
		else
			return new ModelAndView("infos") ;
    }*/
	@RequestMapping(value="/ajout", method=RequestMethod.POST)
    public ModelAndView log4(@ModelAttribute("Pharmacie_medicament") Pharmacie_medicament pharmacie_medicament, HttpServletRequest req) //,@ModelAttribute("Pharmacie") Pharmacie pharmacies
    {   
		Pharmacie p= new Pharmacie() ; 
		HttpSession session = req.getSession();
		Pharmacie p2=(Pharmacie)session.getAttribute("ph") ; 
		
		p.setIdPharma(p2.getIdPharma());
		
		pharmacie_medicament.setPharmacie(p);
	
		int i=pmd.Ajouter(pharmacie_medicament);
		if(i==1)
		{   System.out.println("ok");
	   return new ModelAndView("ajouter-medicament"); }
		else
			return new ModelAndView("infos") ;
    }
	//////////////////////////////////////////////////////////////////////////////
	// en utilisant les sessions
	
	/*@RequestMapping(value="/ajout", method=RequestMethod.POST)
    public ModelAndView loginn(@ModelAttribute("Pharmacie_medicament") Pharmacie_medicament pharmacie_medicament,HttpServletRequest req) //,@ModelAttribute("Pharmacie") Pharmacie pharmacies
    {   
		Pharmacie p= new Pharmacie() ; 
		HttpSession session=req.getSession() ;
		String id=(String) session.getAttribute("idd") ;
		System.out.println(id);
		int id2=Integer.parseInt(id) ;
		p.setIdPharma(id2);
		
		pharmacie_medicament.setPharmacie(p);
	
		int i=pmd.Ajouter(pharmacie_medicament);
		if(i==1)
		{   System.out.println("ok");
	   return new ModelAndView("index"); }
		else
			return new ModelAndView("infos") ;
    }
	*/
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/add_med",method=RequestMethod.GET)
	public ModelAndView login5(){  //int id
		
		
		// System.out.println(id);
		 Pharmacie_medicament pharmacie_medicament= new Pharmacie_medicament() ; 
		 
      ModelAndView model=new ModelAndView("ajouter-medicament","command",pharmacie_medicament);
		//model.addObject("id", id) ;
		List<Medicament> l=medicamentService.All() ; 
		List<String> l2= new ArrayList<String>() ; 
		for(Medicament m : l)
		{
			l2.add(m.getNom()) ; 
		}
		model.addObject("listmed", l2) ;
		 	
		 return model;
	}
	//-------------------------------Test pharmacie-medicament--------------------
	
		/*@RequestMapping("/p_m")
		public ModelAndView index3(){
			
			ModelAndView model =new ModelAndView();
			
		Pharmacie ph=new Pharmacie() ; 
		Pharmacie ph2=new Pharmacie() ; 
		Pharmacie ph3=new Pharmacie() ; 
		ph.setName("a");
		ph2.setName("b");
		ph3.setName("c");
		Medicament m= new Medicament() ; 
		Medicament m2= new Medicament() ; 
		Medicament m3= new Medicament() ; 
		Medicament m4= new Medicament() ; 
		m.setNom("aaaa");
		m2.setNom("bbbb");
		m3.setNom("cccc");
		m4.setNom("dddd");
		
		ph.getMedicaments().add(m)  ; 
		ph.getMedicaments().add(m2)  ;
		ph.getMedicaments().add(m3)  ;
		
		ph2.getMedicaments().add(m2)  ;
		ph2.getMedicaments().add(m3)  ;
		ph3.getMedicaments().add(m4)  ;
		
		
		
		medicamentService.AjouterMed(m);
		medicamentService.AjouterMed(m2);
		medicamentService.AjouterMed(m3);
		medicamentService.AjouterMed(m4);
		
		pharmacienService.AjouterPh(ph);
		pharmacienService.AjouterPh(ph2);
		pharmacienService.AjouterPh(ph3);
		
		
			
			model.setViewName("index");
			return model;
		}
		*/
		
 //------------------------Update Medicament ------------------------------------
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView update(HttpServletRequest req){
	//int id
		
		 //System.out.println(id);
		 Pharmacie_medicament pharmacie_medicament= new Pharmacie_medicament() ; 
		 
     ModelAndView model=new ModelAndView("update-medicament","command",pharmacie_medicament);
     //model.addObject("id", id) ;
     // la liste des medicament de la pharmacie  
     
     
     HttpSession session = req.getSession();
		Pharmacie p2=(Pharmacie)session.getAttribute("ph") ;
     
 	   List<Medicament> l=medicamentService.getMedByPharma(p2.getIdPharma()) ; 
 	  List<Pharmacie_medicament> lpm=medicamentService.getMedByPharma2(p2.getIdPharma()) ; 
 	 session.setAttribute("lpm",lpm) ;
	   List<String> l2= new ArrayList<String>() ; 
	for(Medicament m : l)
	{
		l2.add(m.getNom()) ; 
	}
		 model.addObject("listmed", l2) ;
		
		 	
		 return model;
	}
	/*
	 * 
	 * si on utilise pas la session dans ce cas l id de la pharmacie sera visible dans l'url
	@RequestMapping(value="/update2/{id}", method=RequestMethod.POST)
    public ModelAndView update2(@PathVariable("id") int id,@ModelAttribute("Pharmacie_medicament") Pharmacie_medicament pharmacie_medicament)
    {   
		Pharmacie p= new Pharmacie() ; 
		p.setIdPharma(id);
		pharmacie_medicament.setPharmacie(p);
		pmd.update(pharmacie_medicament);
      System.out.println(pharmacie_medicament.getQuantite()+" "+pharmacie_medicament.getMedicament().getNom()+" "+pharmacie_medicament.getPharmacie().getIdPharma());
     
      	 return new ModelAndView("index") ; 
	    
    }*/
	
	
	@RequestMapping(value="/updat", method=RequestMethod.POST)
    public ModelAndView update2(@ModelAttribute("Pharmacie_medicament") Pharmacie_medicament pharmacie_medicament,HttpServletRequest req)
    {   
		Pharmacie p= new Pharmacie() ; 
		HttpSession session = req.getSession();
		Pharmacie p2=(Pharmacie)session.getAttribute("ph") ; 
		p.setIdPharma(p2.getIdPharma());
		pharmacie_medicament.setPharmacie(p);
		pmd.update(pharmacie_medicament);
      System.out.println(pharmacie_medicament.getQuantite()+" "+pharmacie_medicament.getMedicament().getNom()+" "+pharmacie_medicament.getPharmacie().getIdPharma());
     
      	 return new ModelAndView("redirect:/update") ; 
	    
    }
	
	
	//--------------------------------Livraison------------------------------------------------------------------------------
	
	
	@RequestMapping(value="/AllClient/{boutton}",method = RequestMethod.GET)
	public  @ResponseBody List<Commande> getPharmacies(@PathVariable("boutton") String bouton,HttpServletRequest req, HttpServletResponse response){
		
		
		Pharmacie ph =(Pharmacie)req.getSession().getAttribute("ph") ;
		 List<Commande> list= new ArrayList<Commande>() ; 
		  System.out.println(ph.getIdPharma());
		  System.out.println("le bouton clique est ----->  "+bouton);
	           if(bouton.equals("b"))
	           { list=commandeService. getByIdPharma(ph.getIdPharma()) ; 
                       
	           }  
	           if(bouton.equals("m"))
	           { list=commandeService. getByIdPharma2(ph.getIdPharma()) ; 
                       
	           }  
     
          List<Commande> res= new ArrayList<Commande>() ; 
          if(list.size()!=0){
           res.add(list.get(0)) ; 
          int j ; 
       for(int i=1  ; i<list.size() ; i++)
       {
    	   
    	   for( j=0  ;j<res.size()  ; j++)
    	   
    	       if(res.get(j).getLaltitude()==list.get(i).getLaltitude() && res.get(j).getLongitude()==list.get(i).getLongitude())
    	    	      break ; 
    	   
    	   if(j==res.size())
    		   res.add(list.get(i)) ; 
    		   
       }}
        
        // pour recuperer les donnees de la commandes et les afficher dans un tableau dans la page jsp
         req.getSession().setAttribute("listcommande", res);

		return res;
		/*Pharmacien harmacien=new Pharmacien();
			pharmacien.setCIN("EE543");
			pharmacien.setEmail("ghizo@mail.com");
			pharmacien.setNom("ghizo");
			pharmacien.setPassword("aaa");
			
			return pharmacien;*/

	}
	
	//////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/All",method = RequestMethod.GET)
	public  @ResponseBody ModelAndView get(HttpServletRequest req, HttpServletResponse response){
		
		
		   Date date= new Date() ; 
		   // la date d'ajourd'hui a 12h.00.00
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
  

        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        //
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        
        
		
		
		
		Pharmacie ph =(Pharmacie)req.getSession().getAttribute("ph") ;
		 
		  System.out.println(ph.getIdPharma());
		  List<Commande> list= new ArrayList<Commande>() ; 
	  if(now.getTimeInMillis()<calendar.getTimeInMillis())
        list=commandeService. getByIdPharma(ph.getIdPharma()) ; 
	  else 
	  list=commandeService.getByIdPharma2(ph.getIdPharma()) ; 
     
       
     
          List<Commande> res= new ArrayList<Commande>() ; 
          //la condition ajouter au cas ou la pharmacie n as pas de livraison
          if(list.size()!=0){
           res.add(list.get(0)) ; 
          int j ; 
       for(int i=1  ; i<list.size() ; i++)
       {
    	   
    	   for( j=0  ;j<res.size()  ; j++)
    	   
    	       if(res.get(j).getLaltitude()==list.get(i).getLaltitude() && res.get(j).getLongitude()==list.get(i).getLongitude())
    	    	      break ; 
    	   
    	   if(j==res.size())
    		   res.add(list.get(i)) ; 
    		   
       }}
        
        // pour recuperer les donnees de la commandes et les afficher dans un tableau dans la page jsp
         req.getSession().setAttribute("listcommande", res);
        req.getSession().setAttribute("listAll", list);

		return new ModelAndView("redirect:/livraison");
		/*Pharmacien harmacien=new Pharmacien();
			pharmacien.setCIN("EE543");
			pharmacien.setEmail("ghizo@mail.com");
			pharmacien.setNom("ghizo");
			pharmacien.setPassword("aaa");
			
			return pharmacien;*/

	}
	
	
	
	
}





