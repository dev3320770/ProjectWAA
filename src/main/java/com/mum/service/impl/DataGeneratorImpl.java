package com.mum.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.data.init.BlockBuilder;
import com.mum.data.init.DataGeneratorService;
import com.mum.data.init.SessionBuilder;
import com.mum.model.Block;
import com.mum.model.Course;
import com.mum.model.Faculty;
import com.mum.model.Role;
import com.mum.model.Session;
import com.mum.model.SessionTransaction;
import com.mum.model.SessionType;
import com.mum.model.Student;
import com.mum.model.User;
import com.mum.service.BlockService;
import com.mum.service.CourseService;
import com.mum.service.FacultyService;
import com.mum.service.RoleService;
import com.mum.service.SessionService;
import com.mum.service.SessionTransactionService;
import com.mum.service.StudentService;
import com.mum.service.UserService;

@Service
public class DataGeneratorImpl implements DataGeneratorService {

	@Autowired BlockService blockService;
	@Autowired CourseService courseService;
	@Autowired FacultyService facultyService;
	@Autowired RoleService roleService;
	@Autowired UserService userService;
	@Autowired StudentService studentService;
	@Autowired SessionService sessionService;
	@Autowired SessionTransactionService sessionTransactionService;

	@Override
	public void initialize() {
		// create blocks for each month of the year
		for(int i = 1; i <= 12; ++i) {
			System.out.println(".... adding block");
			Block block = generateBlock(i);
			List<Session> sessions = generateSessions(block);
			List<Course> courses = generateCourses(block);
			block.setSessions(sessions);
			block.setCourses(courses);
			blockService.save(block);
		}
		// create faculties
		generateFaculties();
		assignFacultiesToCourses();
		
		// create students
		generateStudents();
		assignStudentsToCourses();
		
		// generate data to feed system
		exportTextData();
	}
	
	public Block generateBlock(int month) {
		
		int year = 2019;
		int firstDay = 1;
		int lastDay = 28;
		
		String blockName = new DateFormatSymbols().getMonths()[month-1];
		LocalDate startDate = LocalDate.of(year,month,firstDay);
		LocalDate endDate = LocalDate.of(year,month,lastDay);
	
		Block block = new BlockBuilder()
							.withName(blockName)
							.withStartDate(startDate)
							.withEndDate(endDate)
							.build();
		return block;
	}
	
	public List<Session> generateSessions(Block block) {
		List<Session> blockSessions = new ArrayList<>();
		int year = block.getStartDate().getYear();
		int month = block.getStartDate().getMonthValue();
		int startHour = 9;
		int startMinute = 45;
		for(int day = 1; day <= 22; ++day) {
			LocalDate sessionDate = LocalDate.of(year,month,day);
			LocalDateTime startTime = LocalDateTime.of(year,month,day,startHour,startMinute);
			Session session =  new SessionBuilder()
									.withDate(sessionDate)
									.withStartTime(startTime)
									.withType(SessionType.MORNING_MEDITATION)
									.inBlock(block)
									.build();
			blockSessions.add(session);
		}
		System.out.println("\n**************\n" + 
							" Generated " + blockSessions.size() + " sessions for block " + block.getStartDate() +
							"\n**************\n");
		return blockSessions;
	}
	
	private List<Course> generateCourses(Block block) {
		List<Course> courses = new ArrayList<>();
		List<String> courseNames = courseService.getRandomCourseNames();
		for(String courseName : courseNames) {
			Course course = new Course();
			course.setName(courseName);
			course.setCode(courseName + " code");
			course.setDescription(courseName + " description");
			course.setBlock(block);
			courses.add(course);
		}
		System.out.println("\n**************\n" + 
				" Generated " + courses.size() + " courses for block " + block.getStartDate() +
				"\n**************\n");
		return courses;
	}
	
	private void generateFaculties() {
		List<String> facultyNames = facultyService.getFacultyNames();
		for(String name : facultyNames) {
			Faculty faculty = generateFaculty(name);
			System.out.println("ADDING ..... " + faculty.getFirstName() + " " + faculty.getLastName());
			facultyService.save(faculty);
		}
	}
	
	private Faculty generateFaculty(String name) {
		Faculty faculty = new Faculty();
		String[] firstAndLastNames = name.split(" ");
		String firstName = firstAndLastNames[0];
		String lastName = firstAndLastNames[1];
		faculty.setFirstName(firstName);
		faculty.setLastName(lastName);
		String fLast = (firstName.split("")[0]+lastName).toLowerCase();
		faculty.setEmail(fLast +"@mum.edu");
		
		// create a user for faculty
		
		User user = userService.createUser(firstName, lastName);
		user.setActive(1);
		user.addRole(roleService.getRole("faculty"));
		
		// add user to faculty
		faculty.setUser(user);
		
		return faculty;
	}
	
	private Faculty getRandomFaculty(List<Faculty> faculties) {
		return faculties.get((int)(Math.random() * faculties.size()));
	}

	private void assignFacultiesToCourses() {
		List<Block> blocks = blockService.findAll();
		List<Faculty> faculties = facultyService.findAll();
		
		for(Block block : blocks) {
			List<Course> courses = block.getCourses();
			List<Faculty> assignedFaculties = new ArrayList<>(); 
			for(Course course : courses) {
				Faculty faculty = getRandomFaculty(faculties);
				while (assignedFaculties.contains(faculty)) {
					faculty = getRandomFaculty(faculties);
				}
				course.setFaculty(faculty);
				faculty.addCourse(course);
				assignedFaculties.add(faculty);
				facultyService.save(faculty);
			}
		}
	}
	
	private List<Student> students;
	
	private void generateStudents() {
		students = new ArrayList<>();
		List<String> studentNames = studentService.getStudentNames();
		for(String name : studentNames) {
			Student student = generateStudent(name);
			students.add(student);
			System.out.println("ADDING ..... " + student.getFirstName() + " " + student.getLastName());
			studentService.save(student);
		}
	}
	
	
	private boolean duplicateId(String id) {
		for (Student student : students) {
			if (student.getStudentId() == id)
				return true;
		}
		return false;
	}
	
//	private String generateNextStudentId() {
//		String studentId = "98" + (int)((Math.random()*8900)+1100);
//		while(duplicateId(studentId)) {
//			studentId = "98" + (int)((Math.random()*8900)+1100);
//		}
//		return studentId;
//	}
	
	private Student generateStudent(String name) {
		Student student = new Student();
		String[] firstAndLastNames = name.split(" ");
		String firstName = firstAndLastNames[0];
		String lastName = firstAndLastNames[1];
		student.setFirstName(firstName);
		student.setLastName(lastName);
		String fLast = (firstName.split("")[0]+lastName).toLowerCase();
		student.setEmail(fLast +"@mum.edu");
		student.setEntryDate(getRandomEntryDate());
		student.setStudentId(986610 + students.size() + "");
		
		// create a user for student
		User user = userService.createUser(firstName, lastName);
		user.setActive(1);
		user.addRole(roleService.getRole("student"));
		
		// add user to faculty
		student.setUser(user);
		return student;
	}
	
	private LocalDate getRandomEntryDate() {
		List<LocalDate> entryDates = studentService.getEntryDates();
		return entryDates.get(new Random().nextInt(entryDates.size()));
	}
	
	private void assignStudentsToCourses() {
		List<Student> students = studentService.findAll();
		List<Block> blocks = blockService.findAll();
		
		for(Block block : blocks) {
			List<Course> blockCourses = courseService.findAllCoursesByBlock(block.getId());
			assignStudentsToCourses(students, blockCourses);
		}
		
	}
	
	private void assignStudentsToCourses(List<Student> students, List<Course> courses) {
		Collections.shuffle(students);
		Collections.shuffle(courses);
		
		for(int i = 0; i < students.size(); ++i) {
			Course course = courses.get(i%courses.size());
			Student student = students.get(i);
			student.addCourse(course);
			course.addStudent(student);
			studentService.save(student);
		}
	}
	
	private void exportTextData() {
		BufferedWriter writer = null;
	    try {
	        writer = new BufferedWriter(new FileWriter("output.txt"));
	        writer.write(generateTextData());
	        System.out.println("CURRENT PATH: " + System.getProperty("user.dir"));
	    } catch (IOException e) {
	        System.err.println(e);
	    } finally {
	        if (writer != null) {
	            try {
	                writer.close();
	            } catch (IOException e) {
	                System.err.println(e);
	            }
	        }
	    }
	}
	
	private String generateTextData() {
		List<String> meditationSessions = generateSessionTransactions();
		String text = "";
		for(String entry : meditationSessions) {
			System.out.println(entry);
			text += entry + "\n";
		}
		 return text;
	}
	
	private List<String> generateSessionTransactions() {
		List<String> sessionEntries = new ArrayList<>();
		List<Session> meditationSessions = sessionService.findAll();
		List<Student> students = studentService.findAll();
		
		for(Session session : meditationSessions) {
			List<Student> randomStudents = getRandomAttendees(students);
			for(Student student : randomStudents) {
				SessionTransaction transaction = sessionTransactionService.createTransaction(student,session);
				sessionEntries.add(transaction.toString());
			}
		}
		return sessionEntries;
	}

	private List<Student> getRandomAttendees(List<Student> allStudents) {
		int missingStudents = (int)(Math.random()*3);		// everyday only maximum of 3 people miss meditation
		Collections.shuffle(allStudents);
		return allStudents.subList(missingStudents, allStudents.size());
	}
}
