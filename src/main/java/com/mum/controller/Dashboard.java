package com.mum.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Dashboard {
	
	
	@RequestMapping(value= {"/","/dashboard"}, method=RequestMethod.GET)
	public String UserDashboard(Principal principal) {
	
		String role=  ((Authentication) principal).getAuthorities().toString();
		System.out.println(role);
		
		if(role.equals("[ADMIN]")) {
			return "admin/students";
		}
		
		if (role.equals("[FACULTY]")) {
			return "faculty/dashboard";
		}
		
	
		
		return "dashboard";
	}
	
	
	@RequestMapping(value="/admin/students", method=RequestMethod.GET)
	public String getStudents() {
	
		
		return "admin/students";
	}
	
	
	@RequestMapping(value="/admin/entries", method=RequestMethod.GET)
	public String getEntries() {
	
		
		return "admin/entries";
	}
	

}
