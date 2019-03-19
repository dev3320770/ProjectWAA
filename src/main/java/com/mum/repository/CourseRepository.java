package com.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

}
