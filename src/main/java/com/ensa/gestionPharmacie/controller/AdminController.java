package com.ensa.gestionPharmacie.controller;

import javax.swing.plaf.synth.SynthSeparatorUI;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Admin;
import com.ensa.gestionPharmacie.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	//----------------Getters and setters (for injection)------------------
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	//-------------------------------------------------------
	@RequestMapping(value="/admin",method = RequestMethod.GET)
	public ModelAndView login(){
		//ModelAndView model=new ModelAndView();
		 return new ModelAndView("admin-login","command",new Admin());
	}
	
	@RequestMapping(value="/PageAcceuilAdmin",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("admin") Admin admin){  
		ModelAndView model=new ModelAndView();
		System.out.println(admin.getEmail()+" "+admin.getPassword());
		if(adminService.estAdmin(admin.getEmail(), admin.getPassword()))
			model.setViewName("admin-acceuil");
		else
			model.setViewName("index");
			return model;
			
		
    }  
    

}
