package com.ensa.gestionPharmacie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ensa.gestionPharmacie.entity.Test;
import com.ensa.gestionPharmacie.entity.TestFils;
import com.ensa.gestionPharmacie.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService TestService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		
		ModelAndView model =new ModelAndView();
		model.setViewName("index");
		
		List<Test> allTest = TestService.getAllTest();
		model.addObject("allTest", allTest);
		
		return model;
	}
	@RequestMapping("/fuck")
	public ModelAndView index2(){
		
		ModelAndView model =new ModelAndView();
		TestFils test=new TestFils();
		test.setName("houyam");
		test.setNickname("hoy");
		TestService.add(test);
		
		model.setViewName("index");
		
		return model;
	}
}
