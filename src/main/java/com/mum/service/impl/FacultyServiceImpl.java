package com.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Faculty;
import com.mum.repository.FacultyRepository;
import com.mum.service.FacultyService;
@Service
public class FacultyServiceImpl implements FacultyService{
	@Autowired
	FacultyRepository facultyRepository;

	@Override
	public Faculty save(Faculty faculty) {
		// TODO Auto-generated method stub
		return facultyRepository.save(faculty);
	}

	@Override
	public List<Faculty> saveAll(List<Faculty> faculties) {
		// TODO Auto-generated method stub
		return (List<Faculty>) facultyRepository.saveAll(faculties);
	}

	@Override
	public Faculty findById(long id) {
		// TODO Auto-generated method stub
		return facultyRepository.findById(id).get();
	}

	@Override
	public List<Faculty> findAll() {
		// TODO Auto-generated method stub
		return (List<Faculty>) facultyRepository.findAll();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return facultyRepository.count();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return facultyRepository.existsById(id);
	}

}
