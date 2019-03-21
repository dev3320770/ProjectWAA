package com.mum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

	@Query(value="select * from course where block_id = ?1",nativeQuery=true)
	public List<Course> findAllCoursesByBlock(long blockId);
}
