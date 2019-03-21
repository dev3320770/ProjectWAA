package com.mum.service;

import java.util.List;

import com.mum.model.Faculty;



public interface FacultyService {
	
	public Faculty save(Faculty faculty);
	public List<Faculty> saveAll(List<Faculty> faculties);
	public Faculty findById(long id);
	public List<Faculty> findAll();
	public long count();
	public boolean existsById(Long id);
	public List<String> getFacultyNames();
}
