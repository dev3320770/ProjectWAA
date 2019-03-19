package com.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long> {
	

}
