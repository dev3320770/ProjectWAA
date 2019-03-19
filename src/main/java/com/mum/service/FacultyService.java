package com.mum.service;

import java.util.List;

import com.mum.model.Faculty;



public interface FacultyService {
	
	Faculty save(Faculty faculty);
	List<Faculty> saveAll(List<Faculty> faculties);
	Faculty findById(long id);
	List<Faculty> findAll();
	long count();
	boolean existsById(Long id);

}
