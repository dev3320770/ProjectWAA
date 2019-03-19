package com.mum.service.impl;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Block;
import com.mum.model.Session;
import com.mum.model.SessionType;
import com.mum.model.Block.BlockBuilder;
import com.mum.model.Session.SessionBuilder;
import com.mum.service.DataGeneratorService;
import com.mum.service.SessionService;

@Service
public class DataGeneratorImpl implements DataGeneratorService {

	@Autowired 
	SessionService sessionService;

	@Override
	public void initializeBlocksAndSessions() {
		// create blocks for each month of the year
		for(int i = 1; i <= 12; ++i) {
			System.out.println(".... adding block");
			generateBlock(i);
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
							.withDescription(blockName + " block, 2019")
							.withStartDate(startDate)
							.withEndDate(endDate)
							.build();
		
		List<Session> blockSessions = generateSessions(block);
		block.setSessions(blockSessions);
		return block;
	}
	
	@Override
	public List<Session> generateSessions(Block block) {
		List<Session> sessions = new ArrayList<>();
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
			sessions.add(session);
			updateSessionDatabase(session);
		}
		return sessions;
	}
	
	private void updateSessionDatabase(Session session) {
		System.out.println("SAVING SESSION ............................");
		Long sessionId = session.getId();
		Session existingSession = sessionService.findSessionById(sessionId);
		if(existingSession == null)
			sessionService.save(session);
	}
}
