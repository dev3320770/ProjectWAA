package com.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Student;
import com.mum.repository.StudentRepository;
import com.mum.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student save(Student s) {
		return studentRepository.save(s);
	}

	@Override
	public List<Student> findAll() {

		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student findById(long id) {

		return studentRepository.findById(id).get();
	}

	@Override
	public Student findByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentId(studentId);
	}

}
