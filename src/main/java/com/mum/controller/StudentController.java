package com.mum.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mum.model.Course;
import com.mum.model.SessionTransaction;
import com.mum.model.Student;
import com.mum.service.SessionTransactionService;
import com.mum.service.StudentService;

@Controller
@SessionAttributes("user")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@Autowired
	SessionTransactionService sessionTransactionService;
	
//	@Autowired
//	CourseService courseService;
	
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String getStudents(Model model ,Student student) {
		List<Student> students = studentService.findAll();
//		for(Student s: students) {
//			System.out.println(s);
//			
//		}
		
		model.addAttribute("student", students);
		
		return "student/students";
	}
	
	@RequestMapping(value="/students/details/", method=RequestMethod.GET)
	public String studentDetails(@RequestParam("studentId") String studentId, Model model) {
//		Student student = studentService.findByStudentId(studentId);
//		
		Student myst=studentService.findByStudentId(studentId);
		
		List<Course> mylist=myst.getCourses();
		System.out.println(mylist);
		
		List<SessionTransaction>  st = sessionTransactionService.findByStudentId(studentId);

		System.out.println(st);
		
		
		model.addAttribute("courses", mylist.stream().map(c->c.getName()).collect(Collectors.toList()));
		model.addAttribute("student", studentService.findByStudentId(studentId));
		model.addAttribute("tmSessions", sessionTransactionService.findByStudentId(studentId));
		
	
		
		return "student/studentDetails";
	}
	

	


}
