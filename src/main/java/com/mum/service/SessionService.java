package com.mum.service;

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
import com.mum.repository.BlockRepository;
import com.mum.repository.SessionRepository;

@Service
public class SessionService {
	
	@Autowired private SessionRepository sessionRepository;
	@Autowired private BlockRepository blockRepository;
	
	public Session getSessionByID(Long id) {
		return sessionRepository.findById(id).get();
	}
	
	public List<Session> getAllSessionsInBlock (Long blockId) {
		return sessionRepository.getAllSessionInBlock(blockId);
	}
	
	
	// -------------------------- DATA GENERATOR --------------------------------- //
	
	
	// create dummy blocks and sessions
	public void initializeDatabase() {
		// create 12 blocks 
		for(int i = 1; i <= 12; ++i) {
			System.out.println(".... adding block");
			generateBlock(i);
		}
	}
	
	public Block generateBlock(int month) {
		
		int year = 2019;
		int firstDay = 1;
		int lastDay = 28;
		
		Long id = (long)month;
		String blockName = new DateFormatSymbols().getMonths()[month-1];
		LocalDate startDate = LocalDate.of(year,month,firstDay);
		LocalDate endDate = LocalDate.of(year,month,lastDay);

		Block block = new BlockBuilder()
							//.withId(id)
							.withName(blockName)
							.withDescription(blockName + " block, 2019")
							.withStartDate(startDate)
							.withEndDate(endDate)
							.build();
		
		System.out.println("Created Block: " + block);
		List<Session> blockSessions = generateSessions(block);
		block.setSessions(blockSessions);
		return block;
	}
	
	public List<Session> generateSessions(Block block) {
		
		List<Session> sessions = new ArrayList<>();
		
		int year = block.getStartDate().getYear();
		int month = block.getStartDate().getMonthValue();
		int startHour = 9;
		int startMinute = 45;
		
		for(int day = 1; day <= 22; ++day) {
			LocalDate sessionDate = LocalDate.of(year,month,day);
			LocalDateTime startTime = LocalDateTime.of(year,month,day,startHour,startMinute);
			
			// Generate manual ID
			Long id = (long)2019*1000+month*100+day;
			
			// Create a session for current day
			Session session =  new SessionBuilder()
						//.withId(id)
						.withDate(sessionDate)
						.withStartTime(startTime)
						.withType(SessionType.MORNING_MEDITATION)
						.inBlock(block)
						.build();
			
			sessions.add(session);
			updateDatabase(session);
		}
		return sessions;
	}

	private void updateDatabase(Session session) {

		Long sessionId = session.getId();
		Optional<Session> existingSession = null;
		
		try {
			existingSession = sessionRepository.findById(sessionId);
			System.out.println("Existing session: " + existingSession);
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception");
		} finally {
			if(!existingSession.isPresent())
				sessionRepository.save(session);
		}
	}
	
}
