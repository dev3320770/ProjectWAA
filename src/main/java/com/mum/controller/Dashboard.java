package com.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Dashboard {
	

	@RequestMapping(value= {"/","dashboard"}, method=RequestMethod.GET)
	public String UserDashboard() {
		
		
	
		return "dashboard";
	}
	

}
