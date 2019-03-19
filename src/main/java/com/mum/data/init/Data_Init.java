//package com.mum.data.init;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import com.mum.model.*;
//
//public class Data_Init {
//	
//	
//	public static ArrayList<Block> blocks;
//	public static ArrayList<Course> courses;
//	public static ArrayList<Session> sessions;
//	public static ArrayList<Location> locations;
//	public static ArrayList<Faculty> facultyList;
//	public static ArrayList<Student> students;
//	//private static lastSession
//	
//    private synchronized static void initialize() {
//        if(students == null || blocks == null  || locations == null || facultyList == null) {
//        	students = new ArrayList<>();
//        	blocks = new ArrayList<>();
//        	//sessions = new ArrayList<>();
//        	locations = new ArrayList<>();
//        	facultyList = new ArrayList<>();        	
//        	createLocations();
//        	createBlocks();      
//        	createUsers();
//        	createfacultyList();
//        	
//        }
//    }
//    
//    private synchronized static void CreateSessionTransactions() {
//    	
//    	SessionTransaction st1=new SessionTransaction();
//    //	st1.setSessionId();
//    	//st1.setSessionId(sessionId);
//    }
//    
//    
// private synchronized static void createfacultyList() {
//	 Faculty f1=new Faculty();
//	 f1.setDemoID(1);
//	 f1.setName("Tina xing");
//	 f1.setEmail("xing@mum.edu");
//	 f1.setTitle("Professor");
//	 f1.addBlock(blocks.get(0));
//	 f1.addBlock(blocks.get(2));
//	 
//	 Faculty f2=new Faculty();
//	 f2.setDemoID(2);
//	 f2.setName("Levi");
//	 f2.setEmail("levig@mum.edu");
//	 f2.setTitle("Dean");
//	 f2.addBlock(blocks.get(1));
//	 f2.addBlock(blocks.get(4));
//	 
//	 facultyList.add(f1);
//	 facultyList.add(f2);
//     
// }
//    
//    private synchronized static void createUsers() {
//    	LocalDate EntryDateNovember=LocalDate.of(2018, Month.NOVEMBER, 1);
//    	LocalDate EntryDateMarch=LocalDate.of(2018, Month.MARCH, 1);
//    	
//       Student s1=new Student();
//       s1.setDemoID(100);
//       s1.setCode("986923");
//       s1.addBlock(blocks.get(0));
//       s1.addBlock(blocks.get(2));
//       s1.setEmail("ahassanein@mum.edu");
//       s1.setFirstName("Alaa");
//       s1.setLastName("Hassanein");
//       s1.setEntryDate(EntryDateNovember);
//       
//       Student s2=new Student();
//       s2.setDemoID(101);
//       s2.setCode("986999");
//       s2.addBlock(blocks.get(1));
//       s2.addBlock(blocks.get(4));
//       s2.setEmail("Festus@mum.edu");
//       s2.setFirstName("Festus");
//       s2.setLastName("Tuta");
//       s2.setEntryDate(EntryDateMarch);
//       
//       Student s3=new Student();
//       s3.setDemoID(102);
//       s3.setCode("986926");
//       s3.addBlock(blocks.get(0));
//       s3.addBlock(blocks.get(2));
//       s3.setEmail("Dawit@mum.edu");
//       s3.setFirstName("Dawit");
//       s3.setLastName("Dawit");
//       s3.setEntryDate(EntryDateNovember);
//       
//       Student s4=new Student();
//       s4.setDemoID(103);
//       s4.setCode("986234");
//       s4.addBlock(blocks.get(1));
//       s4.addBlock(blocks.get(4));
//       s4.setEmail("Balindra@mum.edu");
//       s4.setFirstName("Balindra");
//       s4.setLastName("Balindra");
//       s4.setEntryDate(EntryDateNovember);
//       
//       students.add(s1);
//       students.add(s2);
//       students.add(s3);
//       students.add(s4);
//       
//       
//     }
//    
//  private synchronized static List<Session> createSessions(LocalDate startDate,LocalDate endDate,long startdemoid) {
//	  
//	  List<Session> retList=new ArrayList<Session>();
//	  int NumberOfSessions = (int) ChronoUnit.DAYS.between(startDate, endDate);
//	  LocalDate currSessDate=startDate;
//	   long currDemoID=startdemoid;
//	  
//	  for(int i=0;i<NumberOfSessions;i++) {
//		  
//		  LocalDateTime startTime=currSessDate.atTime(8, 40);
//		  LocalDateTime endTime=currSessDate.atTime(9, 10);
//		  
//		  Session newSession=new Session();	
//		  newSession.setDemoID(currDemoID);
//		  newSession.setSessionDate(currSessDate);
//		  newSession.setSessionStartTime(startTime);
//		  newSession.setSessionEndTime(endTime);
//		  newSession.setSessionType(SessionType.MORNING_MEDITATION);
//		  retList.add(newSession);
//		  
//		  currSessDate=currSessDate.plusDays(1);
//		  currDemoID++;
//		  
//	  }
//	  
//        return retList;
//    }
//    
//    private synchronized static void createBlocks() {
//    	
//    	
//    	
//    	LocalDate startDate1=LocalDate.of(2019, Month.FEBRUARY, 25);
//    	LocalDate endDate1=LocalDate.of(2019, Month.MARCH, 21);
//    	
//    	LocalDate startDate2=LocalDate.of(2019, Month.APRIL, 1);
//    	LocalDate endDate2=LocalDate.of(2019, Month.APRIL, 25);
//    	
//    	
//    	 LocalDateTime startTime1=startDate1.atTime(13, 0);
//		 LocalDateTime endTime1=endDate1.atTime(15, 0);
//		 
//		 LocalDateTime startTime2=startDate1.atTime(18, 0);
//		 LocalDateTime endTime2=endDate1.atTime(20, 0);
//    	
//		//
//    	Block b1=new Block();
//    	//b1.setId(1);
//    	b1.setCode("CS545");
//    	b1.setName("WAA");
//    	b1.setStartDate(startDate1);
//    	b1.setStartDate(endDate1);
//    	b1.setSessions(createSessions(startDate1,endDate1));    	
//    	// add DC lecture
//    	Session dcSession=new Session();
//    	dcSession.setSessionDate(startDate1);
//    	dcSession.setSessionStartTime(startTime1);
//    	dcSession.setSessionEndTime(endTime1);
//    	dcSession.setSessionType(SessionType.DC_LECTURE);    	
//    	b1.addSession(dcSession);
//    	
//    	
//    	//
//    	Block b2=new Block();
//    	//b2.setId(2);
//    	b2.setCode("CS435");
//    	b2.setName("Algorithm");
//    	b2.setStartDate(startDate1);
//    	b2.setStartDate(endDate1);
//    	b2.setSessions(createSessions(startDate1,endDate1));
//    	// add DC lecture
//    	dcSession.setSessionDate(startDate1);
//    	dcSession.setSessionStartTime(startTime1);
//    	dcSession.setSessionEndTime(endTime1);
//    	dcSession.setSessionType(SessionType.DC_LECTURE);    	
//    	b2.addSession(dcSession);    	
//    	
//    	//
//    	Block b3=new Block();
//    	//b3.setId(3);
//    	b3.setCode("CS422");
//    	b3.setName("DMS");
//    	b3.setStartDate(startDate2);
//    	b3.setStartDate(endDate2);
//    	b3.setSessions(createSessions(startDate2,endDate2));
//    	// add DC lecture
//    	dcSession.setSessionDate(startDate2);
//    	dcSession.setSessionStartTime(startTime2);
//    	dcSession.setSessionEndTime(endTime2);
//    	dcSession.setSessionType(SessionType.DC_LECTURE);    	
//    	b3.addSession(dcSession);
//    	
//    	
//    	//
//    	Block b4=new Block();
//    	//b4.setId(4);
//    	b4.setCode("CS572");
//    	b4.setName("MWA");
//    	b4.setStartDate(startDate2);
//    	b4.setStartDate(endDate2);
//    	b4.setSessions(createSessions(startDate2,endDate2));
//    	// add DC lecture
//    	dcSession.setSessionDate(startDate2);
//    	dcSession.setSessionStartTime(startTime2);
//    	dcSession.setSessionEndTime(endTime2);
//    	dcSession.setSessionType(SessionType.DC_LECTURE);    	
//    	b4.addSession(dcSession);
//    	
//    	//
//    	Block b5=new Block();
//    	//b5.setId(5);
//    	b5.setCode("CS488");
//    	b5.setName("BDA");
//    	b5.setStartDate(startDate2);
//    	b5.setStartDate(endDate2);
//    	b5.setSessions(createSessions(startDate2,endDate2));
//    	// add DC lecture
//    	dcSession.setSessionDate(startDate2);
//    	dcSession.setSessionStartTime(startTime2);
//    	dcSession.setSessionEndTime(endTime2);
//    	dcSession.setSessionType(SessionType.DC_LECTURE);    	
//    	b4.addSession(dcSession);
//    	
//    	blocks.add(b1);
//    	blocks.add(b2);
//    	blocks.add(b3);
//    	blocks.add(b4);
//    	blocks.add(b5);    	
//    	
//    }
//    
// private synchronized static void createLocations() {
//	 Location loc1=new Location();
//	// loc1.setId(1);
//	 loc1.setName("Dalby Hall");
//	 
//	 Location loc2=new Location();
//	// loc2.setId(2);
//	 loc2.setName("Hibernad Hall");
//	 
//	 Location loc3=new Location();
//	// loc3.setId(3);
//	 loc3.setName("Dome High raise");
//	 locations.add(loc1);
//	 locations.add(loc2);
//	 locations.add(loc3);
//        
//    }
//	
//
//}
