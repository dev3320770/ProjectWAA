package com.mum.service;

import java.util.List;

import com.mum.model.Student;


public interface StudentService {
	
	 Student save(Student s);
	 List<Student> findAll();
	 Student findById(long id);
	 Student findByStudentId(String studentId);
	 
//	 int getTotalSessionsPossible(long studentid);
//	 int getTotalSessionsAttended(long studentid);
//	 double getTotalAttributePercentAttendance(long studentid);	 
//	 List<Block> getBlocksByStudentID(long studentid);
//	 
//	 int getNoSessionsInBlock(long sessionid);
//	 int getNoDaysPresentInBlock(long sessionid,long studentNo);
//	 double getPercentageAttendedInBlock(long Sessionid,long studentNo);
//	 double getExtraCreditPointsInBlock(long Sessionid,long studentNo); 

}