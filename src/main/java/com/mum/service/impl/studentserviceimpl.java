package com.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Student;
import com.mum.repository.StudentRepository;
import com.mum.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
@Autowired
	StudentRepository studentRepository;

public Student save(Student s) {
	return studentRepository.save(s);
}

public List<Student> findAll() {
	
	return (List<Student>) studentRepository.findAll();
}	
	
//     public int getTotalSessionsPossible(long studentid) {
//    	 
//		
//		return 0;
//	}
//     public int getTotalSessionsAttended(long studentid) {
// 		
// 		return 0;
// 	}
//	
//     public  double getTotalAttributePercentAttendance(long studentid) {
//  		
//  		return 0;
//  	}
//     
//     public   List<Block> getBlocksByStudentID(long studentid) {
//   		
//   		return new ArrayList<Block>();
//   	}
//		 
//     public int getNoSessionsInBlock(long sessionid) {
//    		
//    		return 0;
//    	}
//	 
//     public int getNoDaysPresentInBlock(long sessionid,long studentNo) {
// 		
// 		return 0;
// 	}
//     
//     public double getPercentageAttendedInBlock(long Sessionid,long studentNo) {
//  		
//  		return 0;
//  	}
//     
//     public double getExtraCreditPointsInBlock(long Sessionid,long studentNo) {
//   		
//   		return 0;
//   	}

	@Override
	public Student findById(long id) {
		
		return studentRepository.findById(id).get();
	}
	
}
