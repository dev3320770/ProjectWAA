package com.mum.service;

import java.util.List;

import com.mum.model.Course;



public interface CourseService {
	
	Course save(Course course);
	List<Course> saveAll(List<Course> courses);
	Course findById(long id);
	List<Course> findAll();
	long count();
	boolean existsById(Long id);

}
