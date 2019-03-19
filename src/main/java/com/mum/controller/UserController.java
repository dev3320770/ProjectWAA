package com.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class UserController {
	

	@RequestMapping(value="/reportform", method=RequestMethod.GET)
	public String StudentForm() {	
		
		
		    // Cumulative attendance info
		// Set Attribute Total sessions possible
		// Set Attribute Total sessions attended
		// Set Attribute Percent attendance
		
		
		// Populate Block List
		   // get List Of Blocks id,Name (may be concat sessionStartDate+"-"+sessionEndTime)
		
		
	
		return "StudentForm";
	}
	
	@RequestMapping(value="/reportform", method=RequestMethod.POST)
	public String getReport(@RequestParam("studentid") String studentid,
			                Model model ) {		
	
		return "StudentForm";
	}
	

}
