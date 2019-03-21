package com.mum.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	public Student findByStudentId(String studentId) {
		return studentRepository.findByStudentId(studentId);
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

	@Override
	public List<String> getStudentNames() {
		List<String> names = new ArrayList<>();
		names.add("Birhane Girmaye");
		names.add("Ujjwol Bandhari");
		names.add("Atif Mukthar");
		names.add("Amjad Karim");
		names.add("Ashok Adhikari");
		names.add("Desudeddit Lutwama");
		names.add("Franscis Blessed");
		names.add("Qua Lar");
		names.add("Elisabeth Melaku");
		names.add("Ehab Tarek");
		names.add("Lewis Che");
		names.add("Ganbat Bayar");
		names.add("Surenkhuu Narankhuu");
		names.add("Ali Asaad");
		names.add("Zia Baig");
		names.add("Thuy Doan");
		names.add("Jason Koirala");
		names.add("Johnson Bokati");
		names.add("Frezer Tadesse");
		return names;
	}
	
	@Override
	public List<LocalDate> getEntryDates() {
		List<LocalDate> entries = new ArrayList<>();
		entries.add(LocalDate.of(2018,2,01));	// February Entry
		entries.add(LocalDate.of(2018,4,01));	// April Entry
		entries.add(LocalDate.of(2018,8,01));	// August Entry
		entries.add(LocalDate.of(2018,11,01));	// November Entry
		return entries;
	}
	
}
