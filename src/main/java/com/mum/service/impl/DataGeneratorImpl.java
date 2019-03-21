package com.mum.service.impl;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.data.init.BlockBuilder;
import com.mum.data.init.DataGeneratorService;
import com.mum.data.init.SessionBuilder;
import com.mum.model.Block;
import com.mum.model.Session;
import com.mum.model.SessionType;
import com.mum.service.SessionService;




@Service
public class DataGeneratorImpl implements DataGeneratorService {

	@Autowired 
	SessionService sessionService;
	
	@Autowired
	CourseService courseService;

	@Override
	public void initializeBlocksAndSessions() {
		// create blocks for each month of the year
		for(int i = 1; i <= 12; ++i) {
			System.out.println(".... adding block");
			Block block = generateBlock(i);
			generateSessions(block);
			generateCourses(block);
		}
	}
	
	@Override
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

	
	private void generateCourses(Block block) {
		List<String> courseNames = courseService.getAllCourseNames();
		int numberOfCoursesInCurrentBlock = (int)Math.random()*courseNames.size();
		Collections.shuffle(courseNames);
		for(int i = 0; i < numberOfCoursesInCurrentBlock; ++i) {
			Course course = new Course();
			String courseName = courseNames.get(i);
			course.setName(courseName);
			course.setCode(courseName + " code");
			course.setDescription(courseName + " description");
			course.setBlock(block);
			courseService.save(course);
		}	
	}

	@Override
	public void generateSessions(Block block) {
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
			block.addSession(session);
			sessionService.save(session);
		}
	}
}
