package com.mum.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	@Query(value="SELECT * FROM Student  WHERE student_id = ?1", nativeQuery = true)
	Student findByStudentId(String studentId);
	
	
	
	// native example
//	@Query(value = "SELECT * FROM emp e WHERE e.F_NAME = ?1", nativeQuery = true)
//	public List<Employee> findByFirstName(String firstName);	
	//@Query(value = "SELECT e FROM Employee e WHERE e.lastName = :lastname")
	//public List<Employee> findByLastName(String lastname);
	
	
	
	
 	//@Query(value = "SELECT * FROM emp e WHERE e.F_NAME = ?1", nativeQuery = true)
	//public int getTotalSessionsPossible(String firstName);
	
	
	
//	int getTotalSessionsPossible(long studentid);
//	 int getTotalSessionsAttended(long studentid);
//	 double getTotalAttributePercentAttendance(long studentid);	 
//	 List<Block> getBlocksByStudentID(long studentid);
//	 
//	 int getNoSessionsInBlock(long sessionid);
//	 int getNoDaysPresentInBlock(long sessionid,long studentNo);
//	 double getPercentageAttendedInBlock(long Sessionid,long studentNo);
//	 double getExtraCreditPointsInBlock(long Sessionid,long studentNo); 
	
   
}