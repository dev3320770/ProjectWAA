package com.mum.data.init;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mum.model.*;

public class Data_Init {
	
	
	public static ArrayList<Block> blocks;
	public static ArrayList<Course> courses;
	public static ArrayList<Session> sessions;
	public static ArrayList<Location> locations;
	public static ArrayList<Faculty> facultyList;
	public static ArrayList<Student> students;
	//private static lastSession
	
    public synchronized static void initialize() {
        if( blocks == null || courses == null  || sessions == null || locations == null || facultyList == null
        		|| students == null) {
        	
        	blocks = new ArrayList<>();
        	courses = new ArrayList<>();
        	sessions = new ArrayList<>();
        	locations = new ArrayList<>();
        	facultyList = new ArrayList<>();
        	students = new ArrayList<>();       	

        	
        	createLocations();
        	createBlocks();      
        	
        	
        }
    }
    
    private synchronized static void CreateSessionTransactions() {
    	
    	SessionTransaction st1=new SessionTransaction();
    //	st1.setSessionId();
    	//st1.setSessionId(sessionId);
    }
    
    
 private synchronized static void createfacultyList() {
	 Faculty f1=new Faculty();
	 f1.setDemoID(1);
	 f1.setFirstName("Tina");
	 f1.setLastName("Xing");
	 f1.setEmail("xing@mum.edu");
	 f1.setTitle("Professor");
	 f1.setCourse(courses.get(0));
	 
	 
	 Faculty f2=new Faculty();
	 f2.setDemoID(2);
	 f2.setFirstName("Levi");
	 f2.setFirstName("Levi");
	 f2.setEmail("levig@mum.edu");
	 f2.setTitle("Dean");
	 f2.setCourse(courses.get(1));
	 
	 facultyList.add(f1);
	 facultyList.add(f2);
     
 }
    
    private synchronized static void createStudents() {
    	LocalDate EntryDateNovember=LocalDate.of(2018, Month.NOVEMBER, 1);
    	LocalDate EntryDateMarch=LocalDate.of(2018, Month.MARCH, 1);
    	
       Student s1=new Student();
       s1.setDemoID(100);
       s1.setCode("986923");
       s1.setCourse(courses.get(0));      
       s1.setEmail("ahassanein@mum.edu");
       s1.setFirstName("Alaa");
       s1.setLastName("Hassanein");
       s1.setEntryDate(EntryDateNovember);
       
       Student s2=new Student();
       s2.setDemoID(101);
       s2.setCode("986999");
       s2.setCourse(courses.get(1));
       s2.setEmail("Festus@mum.edu");
       s2.setFirstName("Festus");
       s2.setLastName("Tuta");
       s2.setEntryDate(EntryDateMarch);
       
       Student s3=new Student();
       s3.setDemoID(102);
       s3.setCode("986926");
       s1.setCourse(courses.get(2));
       s3.setEmail("Dawit@mum.edu");
       s3.setFirstName("Dawit");
       s3.setLastName("Dawit");
       s3.setEntryDate(EntryDateNovember);
       
       Student s4=new Student();
       s4.setDemoID(103);
       s4.setCode("986234");
       s1.setCourse(courses.get(3));
       s4.setEmail("Balindra@mum.edu");
       s4.setFirstName("Balindra");
       s4.setLastName("Balindra");
       s4.setEntryDate(EntryDateNovember);
       
       students.add(s1);
       students.add(s2);
       students.add(s3);
       students.add(s4);
       
       
     }
    
  private synchronized static List<Session> createSessions(LocalDate startDate,LocalDate endDate,long StartDemoId) {
	  
	  List<Session> retList=new ArrayList<Session>();
	  int NumberOfSessions = (int) ChronoUnit.DAYS.between(startDate, endDate);
	  LocalDate currSessDate=startDate;
	   long currDemoID=StartDemoId;
	  
	  for(int i=0;i<=NumberOfSessions;i++) {
		  if( currSessDate.getDayOfWeek() != DayOfWeek.SUNDAY)
		  {
		  
		  LocalDateTime startTime=currSessDate.atTime(8, 40);
		  LocalDateTime endTime=currSessDate.atTime(9, 10);
		  
		  Session newSession=new Session();	
		  newSession.setDemoID(currDemoID);
		  newSession.setSessionDate(currSessDate);
		  newSession.setSessionStartTime(startTime);
		  newSession.setSessionEndTime(endTime);
		  newSession.setSessionType(SessionType.MORNING_MEDITATION);
		  newSession.setLocation(locations.get(0));
		  
		  
		  
		
		  retList.add(newSession);
		  
		 
		  
		  }
		  currSessDate=currSessDate.plusDays(1);
		  currDemoID++;
		  
	  }
	  
        return retList;
    }
    
    private synchronized static void createBlocks() {
    	
    	 Faculty f1=new Faculty();
    	 f1.setDemoID(1);
    	 f1.setFirstName("Tina");
    	 f1.setLastName("Xing");
    	 f1.setEmail("xing@mum.edu");
    	 f1.setTitle("Professor");
    	 f1.setCourse(new Course());
    	// f1.setCourse(courses.get(0));
    	 
    	 
    	 Faculty f2=new Faculty();
    	 f2.setDemoID(2);
    	 f2.setFirstName("Levi");
    	 f2.setFirstName("Levi");
    	 f2.setEmail("levig@mum.edu");
    	 f2.setTitle("Dean");
    	 f2.setCourse(new Course());
    	// f2.setCourse(courses.get(1));
    	 
    	 facultyList.add(f1);
    	 facultyList.add(f2);
    	 
    	 
    	 LocalDate EntryDateNovember=LocalDate.of(2018, Month.NOVEMBER, 1);
     	LocalDate EntryDateMarch=LocalDate.of(2018, Month.MARCH, 1);
    	 Student s1=new Student();
         s1.setDemoID(100);
         s1.setCode("986923");
         s1.setCourse(new Course());  
         //s1.setCourse(courses.get(0));      
         s1.setEmail("ahassanein@mum.edu");
         s1.setFirstName("Alaa");
         s1.setLastName("Hassanein");
         s1.setEntryDate(EntryDateNovember);
         
         Student s2=new Student();
         s2.setDemoID(101);
         s2.setCode("986999");
         s2.setCourse(new Course());  
        // s2.setCourse(courses.get(1));
         s2.setEmail("Festus@mum.edu");
         s2.setFirstName("Festus");
         s2.setLastName("Tuta");
         s2.setEntryDate(EntryDateMarch);
         
         Student s3=new Student();
         s3.setDemoID(102);
         s3.setCode("986926");
         s3.setCourse(new Course());  
         //s3.setCourse(courses.get(2));
         s3.setEmail("Dawit@mum.edu");
         s3.setFirstName("Dawit");
         s3.setLastName("Dawit");
         s3.setEntryDate(EntryDateNovember);
         
         Student s4=new Student();
         s4.setDemoID(103);
         s4.setCode("986234");
         s4.setCourse(new Course());  
         //s1.setCourse(courses.get(3));
         s4.setEmail("Balindra@mum.edu");
         s4.setFirstName("Balindra");
         s4.setLastName("Balindra");
         s4.setEntryDate(EntryDateNovember);
         
         students.add(s1);
         students.add(s2);
         students.add(s3);
         students.add(s4);
    	
    	
    	
    	    	
    	LocalDate startDate1=LocalDate.of(2019, Month.FEBRUARY, 25);
    	LocalDate endDate1=LocalDate.of(2019, Month.MARCH, 21);
    	
    	LocalDate startDate2=LocalDate.of(2019, Month.APRIL, 1);
    	LocalDate endDate2=LocalDate.of(2019, Month.APRIL, 25);
    	
    	
    	 LocalDateTime startTime1=startDate1.atTime(13, 0);
		 LocalDateTime endTime1=startDate1.atTime(15, 0);
		 
		 LocalDateTime startTime2=startDate1.atTime(18, 0);
		 LocalDateTime endTime2=startDate1.atTime(20, 0);
    	
		//
    	Block b1=new Block();
    	//b1.setId(1);
    	b1.setDemoID(20);
    	b1.setName("Block1");
    	b1.setStartDate(startDate1);
    	b1.setEndDate(endDate1);
    	b1.setSessions(createSessions(startDate1,endDate1,21));    	
    	// add DC lecture
    	Session dcSession=new Session();
    	dcSession.setSessionDate(startDate1);
    	dcSession.setSessionStartTime(startTime1);
    	dcSession.setSessionEndTime(endTime1);
    	dcSession.setSessionType(SessionType.DC_LECTURE);    	
    	b1.addSession(dcSession);
    	// add courses
    	Course c1=new Course();    	
    	c1.setDemoID(545);
    	c1.setName("WAA");
    	c1.setBlock(b1);
    	//c1.setFaculty(new Faculty());
        c1.setFaculty(facultyList.get(0));
        f1.setCourse(c1);
       
    	// add students to course
    	Set<Student> studentlistC1=new HashSet<>();
    	studentlistC1.add(students.get(0));
    	s1.setCourse(c1);
    	studentlistC1.add(students.get(1));  
    	s2.setCourse(c1);
    	c1.setStudents(studentlistC1);
    	b1.addCourse(c1);
    	
    	courses.add(c1);
    	
    	Course c2=new Course();
    	c2.setDemoID(435);
    	c2.setName("BDA");
    	c2.setBlock(b1);
    	c2.setFaculty(facultyList.get(1));
    	f2.setCourse(c2);
    	// add students to course
    	Set<Student> studentlistC2=new HashSet<>();
    	studentlistC2.add(students.get(2));
    	s3.setCourse(c2);
    	studentlistC2.add(students.get(3));   
    	s4.setCourse(c2);
    	c2.setStudents(studentlistC2);
    	b1.addCourse(c2);
    	
    	courses.add(c2);
    	//
    	Block b4=new Block();
    	b4.setDemoID(110);
    	//b4.setId(4);
    	//b4.setCode("CS572");
    	b4.setName("Block2");
    	b4.setStartDate(startDate2);
    	b4.setEndDate(endDate2);
    	b4.setSessions(createSessions(startDate2,endDate2,111));
    	// add DC lecture
    	dcSession.setSessionDate(startDate2);
    	dcSession.setSessionStartTime(startTime2);
    	dcSession.setSessionEndTime(endTime2);
    	dcSession.setSessionType(SessionType.DC_LECTURE);    	
    	b4.addSession(dcSession);
    	// add courses
    	Course c3=new Course();
    	c3.setDemoID(578);
    	c3.setName("Algorithm");
    	c3.setBlock(b4);
    	c3.setFaculty(facultyList.get(0));
    	
    	// add students to course
    	Set<Student> studentlistC3=new HashSet<>();
    	studentlistC3.add(students.get(0));
    	studentlistC3.add(students.get(1));    	
    	c3.setStudents(studentlistC3);
    	b4.addCourse(c3);
    	
    	courses.add(c3);    	
    	
    	blocks.add(b1);
    	blocks.add(b4);
    	
    	
    	
    	List<SessionTransaction> listTransaction=new ArrayList<>();
    	// set SessionTransaction
    	SessionTransaction st1=new SessionTransaction();
    	st1.setSessId(21);
    	st1.setStudId(986923);
    	st1.setCheckinDate(blocks.get(0).getSessions().get(0).getSessionDate());
    	st1.setAmORpm("AM");
    	st1.setLocation(blocks.get(0).getSessions().get(0).getLocation().getName());
    	st1.setFullStudentName(students.get(0).getFirstName());
    	st1.setStudent(students.get(0));
    	listTransaction.add(st1);
    	
    	SessionTransaction st2=new SessionTransaction();
    	st2.setSessId(22);
    	st2.setStudId(986923);
    	st2.setCheckinDate(blocks.get(0).getSessions().get(1).getSessionDate());
    	st2.setAmORpm("AM");
    	st2.setLocation(blocks.get(0).getSessions().get(1).getLocation().getName());
    	st2.setFullStudentName(students.get(0).getFirstName());
    	st1.setStudent(students.get(1));
    	listTransaction.add(st2);
    	int t=0;
    		
    	
    }
    
 private synchronized static void createLocations() {
	 Location loc1=new Location();
	 loc1.setDemoID(1);
	 loc1.setName("Dalby Hall");
	 
	 Location loc2=new Location();
	 loc2.setDemoID(2);
	// loc2.setId(2);
	 loc2.setName("Hibernad Hall");
	 
	 Location loc3=new Location();
	 loc3.setDemoID(3);
	// loc3.setId(3);
	 loc3.setName("Dome High raise");
	 locations.add(loc1);
	 locations.add(loc2);
	 locations.add(loc3);
        
    }
	

}
