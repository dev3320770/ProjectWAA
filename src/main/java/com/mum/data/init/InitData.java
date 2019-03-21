package com.mum.data.init;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.model.Block;
import com.mum.model.Course;
import com.mum.model.Faculty;
import com.mum.model.Location;
import com.mum.model.Session;
import com.mum.model.SessionType;
import com.mum.model.Student;
import com.mum.repository.*;

@Component
public class InitData {
	
	@Autowired
	private BlockRepository blockRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private StudentRepository studentkRepository;
	@Autowired
	private UserRepository userRepository;
	
	public  ArrayList<Block> blocks;
	public  ArrayList<Course> courses;
	public  ArrayList<Session> sessionsList1B1;
	public  ArrayList<Session> sessionsList2B2;
	public  ArrayList<Location> locations;
	public  ArrayList<Faculty> facultyList;
	public  ArrayList<Student> students;
	LocalDate startDate1=LocalDate.of(2019, Month.FEBRUARY, 25);
 	LocalDate endDate1=LocalDate.of(2019, Month.MARCH, 21); 	
 	LocalDate startDate2=LocalDate.of(2019, Month.APRIL, 1);
 	LocalDate endDate2=LocalDate.of(2019, Month.APRIL, 25); 	
	 public  void initialize() {
	        if(blocks==null || courses==null ||sessionsList2B2==null || sessionsList1B1==null || students == null || blocks == null  || locations == null || facultyList == null) {
	        	students = new ArrayList<>();
	        	courses=new ArrayList<>();
	        	blocks = new ArrayList<>();
	        	sessionsList1B1 = new ArrayList<>();
	        	sessionsList2B2 = new ArrayList<>();
	        	locations = new ArrayList<>();
	        	facultyList = new ArrayList<>();    	        	
	        	// Create Objects without relations
	        	createLocations();
	        	createfacultyList();
	        	createStudents() ;	        	
	        	createCourses();
	        	createSessionsLists();
	        	createBlocks();      	
	        	saveModelsNoRelations();
	        	
	        }
	    }
	 
	 private  void saveModelsNoRelations() {		 
		 locationRepository.saveAll(locations);	
		
		 facultyList.get(0).setUser(userRepository.findById(5).get());
		 facultyList.get(1).setUser(userRepository.findById(8).get());
		 facultyRepository.saveAll(facultyList);
		 
		 
		 students.get(0).setUser(userRepository.findById(3).get());
		 students.get(1).setUser(userRepository.findById(1).get());
		 students.get(2).setUser(userRepository.findById(2).get());
		 students.get(3).setUser(userRepository.findById(4).get());		 
    	 studentkRepository.saveAll(students);
    	 
    	 
		 courseRepository.saveAll(courses);		 
		 
		 blockRepository.saveAll(blocks);
		 
		 // SetBlocks for sessionList
		 for(int i=0;i<sessionsList1B1.size();i++)
		 {
			 sessionsList1B1.get(i).setBlock(blocks.get(0));			 
		 }
		 sessionRepository.saveAll(sessionsList1B1);		 
		 for(int i=0;i<sessionsList2B2.size();i++)
		 {
			 sessionsList2B2.get(i).setBlock(blocks.get(1));			 
		 }
    	 sessionRepository.saveAll(sessionsList2B2);
    	 
    	 
    	 
    	 // set List of Sessions to Blocks
    	// List<Blocks> 
	 		 
	 }
	 private  void createLocations() {
		 Location loc1=new Location();
		loc1.setName("Dalby Hall");		 
		 Location loc2=new Location();		
		 loc2.setName("Hibernad Hall");				
		 locations.add(loc1);
		 locations.add(loc2);		 	        
	    }
	 
	 private void createfacultyList() {
		 Faculty f1=new Faculty();		
		 f1.setFirstName("Tina xing");
		 f1.setEmail("xing@mum.edu");		 
		 Faculty f2=new Faculty();		
		 f2.setFirstName("Levi");
		 f2.setEmail("levig@mum.edu");		
		 facultyList.add(f1);
		 facultyList.add(f2);	     
	 }
     private void createStudents() {
	    	LocalDate EntryDateNovember=LocalDate.of(2018, Month.NOVEMBER, 1);
	    	LocalDate EntryDateMarch=LocalDate.of(2018, Month.MARCH, 1);
	    	
	       Student s1=new Student();	      
	       s1.setEmail("ahassanein@mum.edu");
	       s1.setFirstName("Alaa");
	       s1.setLastName("Hassanein");
	       s1.setEntryDate(EntryDateNovember);
	       
	       Student s2=new Student();	       
	       s2.setEmail("Festus@mum.edu");
	       s2.setFirstName("Festus");
	       s2.setLastName("Tuta");
	       s2.setEntryDate(EntryDateNovember);
	       
	       Student s3=new Student();
	       s3.setEmail("Dawit@mum.edu");
	       s3.setFirstName("Dawit");
	       s3.setLastName("Dawit");
	       s3.setEntryDate(EntryDateMarch);
	       
	       Student s4=new Student();
	       s4.setEmail("Balindra@mum.edu");
	       s4.setFirstName("Balindra");
	       s4.setLastName("Balindra");
	       s4.setEntryDate(EntryDateMarch);
	       
	       students.add(s1);
	       students.add(s2);
	       students.add(s3);
	       students.add(s4);	       
	     }

     private  void createSessionsLists() {
    	 sessionsList1B1= (ArrayList<Session>) createSessions(startDate1,endDate1);
    	 sessionsList2B2= (ArrayList<Session>) createSessions(startDate2,endDate2);     
     }
     
     private  void createCourses() {
    	 Course c1=new Course();
    	 c1.setCode("545");
    	 c1.setName("WAA");
    	 Course c2=new Course();
    	 c2.setCode("445");
    	 c2.setName("Algorithm");
    	 courses.add(c1);
    	 courses.add(c2);
     }
     private  void createBlocks() {     	
     	Block b1=new Block();
     	b1.setName("Febraury-March");
     	b1.setStartDate(startDate1);
     	b1.setStartDate(endDate1);
     	//b1.setSessions(createSessions(startDate1,endDate1,b1));        	
     	Block b2=new Block();
     	b2.setName("April-April");
     	b2.setStartDate(startDate2);
     	b2.setStartDate(endDate2);
     	//b2.setSessions(createSessions(startDate2,endDate2,b1));  
     	
     	blocks.add(b1);     
     	blocks.add(b2);     
     }
     
     private  List<Session> createSessions(LocalDate startDate,LocalDate endDate) {
   	  
   	  List<Session> retList=new ArrayList<Session>();
   	  int NumberOfSessions = (int) ChronoUnit.DAYS.between(startDate, endDate);
   	  LocalDate currSessDate=startDate;
   	    	  
   	  for(int i=0;i<=NumberOfSessions;i++) {
   		  
   		if( currSessDate.getDayOfWeek() != DayOfWeek.SUNDAY)
		  {
		  
		  LocalDateTime startTime=currSessDate.atTime(8, 40);
		  LocalDateTime endTime=currSessDate.atTime(9, 10);
		  
		  Session newSession=new Session();	
		  newSession.setSessionDate(currSessDate);
		  newSession.setSessionStartTime(startTime);
		  newSession.setSessionType(SessionType.MORNING_MEDITATION);
		 // newSession.setBlock(block);
		 // newSession.setLocation(locations.get(0));		
		  retList.add(newSession);		  
		  }
		  currSessDate=currSessDate.plusDays(1);   		  
   	  }
   	  
           return retList;
       }
}
