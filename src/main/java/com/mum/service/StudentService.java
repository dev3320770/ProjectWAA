package com.mum.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.mum.model.Student;


public interface StudentService {
	
	public Student save(Student s);
	public List<Student> findAll();
	public Student findById(long id);
	public Student findByStudentId(String id);
	public List<String> getStudentNames();
	public List<LocalDate> getEntryDates();	 
	 
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