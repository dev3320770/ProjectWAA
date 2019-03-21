package com.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mum.model.Faculty;
import com.mum.model.Student;
import com.mum.service.FacultyService;

@Controller
@SessionAttributes("user")
public class FacultyController {
	@Autowired
	FacultyService facultyService;
	
	@RequestMapping(value="/faculties", method=RequestMethod.GET)
	public String getFuculties(Model model ,Faculty faculty) {
		List<Faculty> faculties = facultyService.findAll();
		for(Faculty f: faculties) {
			System.out.println(f);
			
		}
		
		model.addAttribute("faculty", faculties);
		
		return "faculty/faculties";
	}
	
	@RequestMapping(value="/faculty", method=RequestMethod.GET)
	public String FuculatyDashboard() {
	
		
		return "faculty/facultyDashboard";
	}

}
