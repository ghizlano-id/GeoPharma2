package com.ensa.gestionPharmacie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacie;
import com.ensa.gestionPharmacie.entity.Pharmacie_medicament;
import com.ensa.gestionPharmacie.entity.Pharmacien;
import com.ensa.gestionPharmacie.service.MedicamentService;
import com.ensa.gestionPharmacie.service.PharmacieService;
import com.ensa.gestionPharmacie.service.Pharmacie_medicamentService;
import com.ensa.gestionPharmacie.service.PharmacienService;





@Controller
public class PharmacienController {
	
	

@Autowired
  private  PharmacienService pharmacienService; 

   
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

	

	
	



	@RequestMapping("/pharmacien_acceuil")
	public ModelAndView login2(){
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
    public ModelAndView login(@ModelAttribute("pharmacien") Pharmacien pharmacien)
    {   
		ModelAndView model=new ModelAndView();
		String id=pharmacienService.estPharmacien(pharmacien.getEmail(), pharmacien.getPassword()) ;
		int pharmacie_id=0 ;
		
      if(id!="empty")
        
      {  
    	  pharmacie_id=pharmacieService.getId(id) ;
    	    System.out.println(pharmacie_id);
    	  model.addObject("id", pharmacie_id) ; 
	 	model.setViewName("pharmacien-acceuil");
    	  
    	  return model ; }
      
      else 
      {    
      	 return new ModelAndView("index") ; }
	    
    }
	
	@RequestMapping(value="/pharmacien",method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView model=new ModelAndView("pharmacien-login","command",new Pharmacien());
		 	
		 return model;
	}
	

	//----------------------Ajouter medicament-----------------------
	
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
    }
	
	@RequestMapping(value="/add_med",method=RequestMethod.GET)
	public ModelAndView login5(int id){
		 System.out.println(id);
		 Pharmacie_medicament pharmacie_medicament= new Pharmacie_medicament() ; 
		 
      ModelAndView model=new ModelAndView("ajouter-medicament","command",pharmacie_medicament);
		model.addObject("id", id) ;
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
	public ModelAndView update(int id){
	
		
		 System.out.println(id);
		 Pharmacie_medicament pharmacie_medicament= new Pharmacie_medicament() ; 
		 
     ModelAndView model=new ModelAndView("update-medicament","command",pharmacie_medicament);
     model.addObject("id", id) ;
     
 	List<Medicament> l=medicamentService.All() ; 
	List<String> l2= new ArrayList<String>() ; 
	for(Medicament m : l)
	{
		l2.add(m.getNom()) ; 
	}
		 model.addObject("listmed", l2) ;
		
		 	
		 return model;
	}
	
	@RequestMapping(value="/update2/{id}", method=RequestMethod.POST)
    public ModelAndView update2(@PathVariable("id") int id,@ModelAttribute("Pharmacie_medicament") Pharmacie_medicament pharmacie_medicament)
    {   
		Pharmacie p= new Pharmacie() ; 
		p.setIdPharma(id);
		pharmacie_medicament.setPharmacie(p);
		pmd.update(pharmacie_medicament);
      System.out.println(pharmacie_medicament.getQuantite()+" "+pharmacie_medicament.getMedicament().getNom()+" "+pharmacie_medicament.getPharmacie().getIdPharma());
     
      	 return new ModelAndView("index") ; 
	    
    }
	
	
	
}





