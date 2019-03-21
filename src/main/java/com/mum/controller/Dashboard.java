package com.mum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mum.data.init.InitData;
import com.mum.model.User;
import com.mum.service.UserService;



@Controller
@SessionAttributes("user")
public class Dashboard {
	@Autowired
	UserService userService;
	
//	@Autowired
//	private InitData initData;
	@RequestMapping(value= {"/","/dashboard"}, method=RequestMethod.GET)
	public String UserDashboard(Principal principal, Model model) {
		
		User user = userService.findUserByUsername(principal.getName());
		System.out.println(user.getFirstName());
		model.addAttribute("user" , user);
		
		String role=  ((Authentication) principal).getAuthorities().toString();
		
		System.out.println(principal);
		
		if(role.equals("[ADMIN]")) {
			//initData.initialize();
			return "admin/entries";
		}
		
		if (role.equals("[FACULTY]")) {
			return "admin/facultyDashboard";
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
	
	
	@RequestMapping(value="/admin/faculties", method=RequestMethod.GET)
	public String getFuculties() {
	
		
		return "admin/faculties";
	}
	
	@RequestMapping(value="/admin/students/details", method=RequestMethod.GET)
	public String studentDetails() {
	
		
		return "admin/studentDetails";
	}
	
	@RequestMapping(value="/admin/block/details", method=RequestMethod.GET)
	public String blockDetails() {
	
		
		return "admin/blockDetails";
	}

}
