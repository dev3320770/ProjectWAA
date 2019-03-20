package com.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mum.model.Student;
import com.mum.service.StudentService;
@RestController
public class RestFullController {
	@Autowired
	StudentService studentService;
	
	@GetMapping(value = "api/students/details/{studentId}")
	public @ResponseBody Student getStudentByID(@PathVariable("studentId") String studentId) {
		System.out.println(studentId);
		Student stu = studentService.findByStudentId(studentId);
		System.out.println(stu);
	return stu;
	}

}
