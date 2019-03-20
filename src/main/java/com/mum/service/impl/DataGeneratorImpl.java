package com.mum.service.impl;

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
import com.mum.model.SessionType;
import com.mum.model.Student;
import com.mum.model.User;
import com.mum.service.BlockService;
import com.mum.service.CourseService;
import com.mum.service.FacultyService;
import com.mum.service.RoleService;
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
	
	private void generateStudents() {
		List<String> studentNames = studentService.getStudentNames();
		for(String name : studentNames) {
			Student student = generateStudent(name);
			System.out.println("ADDING ..... " + student.getFirstName() + " " + student.getLastName());
			studentService.save(student);
		}
	}
	
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
}
