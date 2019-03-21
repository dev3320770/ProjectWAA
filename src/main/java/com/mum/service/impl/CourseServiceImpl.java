package com.mum.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Course;
import com.mum.repository.CourseRepository;
import com.mum.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Course save(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public List<Course> saveAll(List<Course> courses) {
		// TODO Auto-generated method stub
		return (List<Course>) courseRepository.saveAll(courses);
	}

	@Override
	public Course findById(long id) {
		// TODO Auto-generated method stub
		return courseRepository.findById(id).get();
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return courseRepository.count();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return courseRepository.existsById(id);
	}
	
	@Override
	public List<String> getAllCourseNames() {
		List<String> courseNames = new ArrayList<>();
		courseNames.add("FPP");
		courseNames.add("MPP");
		courseNames.add("WAP");
		courseNames.add("WAA");
		courseNames.add("EA");
		courseNames.add("MWA");
		courseNames.add("Algorithms");
		courseNames.add("Big Data");
		courseNames.add("Career Strategies");
		return courseNames;
	}
	
	@Override
	public List<String> getRandomCourseNames() {
		List<String> courseNames = getAllCourseNames();
		int numberOfCourses = (int)(Math.random() * courseNames.size());
		for(int i = 0; i < (courseNames.size() - numberOfCourses); ++i) {
			courseNames.remove(0);
		}
		Collections.shuffle(courseNames);
		return courseNames;
	}

}
