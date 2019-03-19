package com.mum.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mum.model.Block;
import com.mum.model.Role;
import com.mum.model.Student;
import com.mum.model.User;
import com.mum.repository.RoleRepository;
import com.mum.repository.UserRepository;


public interface StudentService {
	
	 Student save(Student s);
	 List<Student> findAll();
	 Optional<Student> findById(long id);	 
	 
	 int getTotalSessionsPossible(long studentid);
	 int getTotalSessionsAttended(long studentid);
	 double getTotalAttributePercentAttendance(long studentid);	 
	 List<Block> getBlocksByStudentID(long studentid);
	 
	 int getNoSessionsInBlock(long sessionid);
	 int getNoDaysPresentInBlock(long sessionid,long studentNo);
	 double getPercentageAttendedInBlock(long Sessionid,long studentNo);
	 double getExtraCreditPointsInBlock(long Sessionid,long studentNo); 

}