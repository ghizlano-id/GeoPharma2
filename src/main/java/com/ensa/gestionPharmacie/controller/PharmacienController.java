package com.ensa.gestionPharmacie.controller;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Medicament;
import com.ensa.gestionPharmacie.entity.Pharmacien;
import com.ensa.gestionPharmacie.service.PharmacienService;





@Controller
public class PharmacienController {
	
	

@Autowired
  private  PharmacienService pharmacienService; 
	
  //------------------getters & setters ---------------
	public PharmacienService getPharmacienService() {
		return pharmacienService;
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
      if(pharmacienService.estPharmacien(pharmacien.getEmail(), pharmacien.getPassword()))
        
      {  
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
	
	@RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public ModelAndView login4(@ModelAttribute("medicament") Medicament medicament)
    {   
		pharmacienService.AjouterMed(medicament);
		
   
	   return new ModelAndView("ajouter-medicament"); 
    }
	
	@RequestMapping(value="/add_med",method=RequestMethod.GET)
	public ModelAndView login5(){
		 
		Medicament medicament= new Medicament() ; 
		ModelAndView model=new ModelAndView("ajouter-medicament","command",medicament);
		 	
		 return model;
	}
	/*
	@RequestMapping("/ajouter_med")
	public ModelAndView login6(){
		ModelAndView model=new ModelAndView();
		 	model.setViewName("ajouter-medicament");
		 return model;
	}
	
	*/

	//-----------------------medicament---------------------
       
	@RequestMapping("/ajoutm")
	public ModelAndView ajout(){
		ModelAndView model=new ModelAndView();
		
		Medicament m = new Medicament() ; 
		m.setNom("Doliprane");
		m.setPrix(20);
		m.setDescription("Douleur et Fievre");
		m.setPhoto("pas de photo");
		pharmacienService.AjouterMed(m);
		
		 	model.setViewName("index");
		 return model;
	}
  
}





