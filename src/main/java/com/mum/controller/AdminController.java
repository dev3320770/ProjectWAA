package com.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mum.model.Student;
import com.mum.service.StudentService;
@Controller
@SessionAttributes("user")
public class AdminController {
	
	@Autowired
	StudentService studentService;

	@RequestMapping(value="/entries", method=RequestMethod.GET)
	public String getEntries(Model model ,Student student) {
		List<Student> students = studentService.findAll();
//		for(Student s: students) {
//			System.out.println(s);
//			
//		}
		
		model.addAttribute("student", students);
		
		return "admin/entries";
	}
	


}
