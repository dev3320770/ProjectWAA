package com.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class FacultyController {
	
	@RequestMapping(value="/faculties", method=RequestMethod.GET)
	public String getFuculties() {
	
		
		return "faculty/faculties";
	}
	
	@RequestMapping(value="/faculty", method=RequestMethod.GET)
	public String FuculatyDashboard() {
	
		
		return "faculty/facultyDashboard";
	}

}
