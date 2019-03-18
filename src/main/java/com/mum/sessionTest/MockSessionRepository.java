package com.mum.sessionTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mum.model.Block;
import com.mum.model.Session;
import com.mum.model.SessionType;

@Repository
public class MockSessionRepository {
	
	
	private SessionDatabase sessionDatabase = new SessionDatabase();
	private BlockDatabase blockDatabase = new BlockDatabase();

	
	public Session findById(Long id) {
		return sessionDatabase.findById(id);
	}
	
	public List<Session> getAllSessions() {
		return sessionDatabase.getAllSessions();
	}
	
	public List<Session> getAllSessionsInBlock(Long blockId) {
		Block block = blockDatabase.findById(blockId);
		return block.getSessions();
	}
	
	public List<Session> getSessionsInBlockByType(Long blockId, SessionType type) {
		Block block = blockDatabase.findById(blockId);
		List<Session> allBlockSessions = block.getSessions();
		List<Session> requiredSessions = new ArrayList<>();
		for (Session session : allBlockSessions) {
			if (session.getSessionType() == type) {
				requiredSessions.add(session);
			}
		}
		return requiredSessions;
	}
	
	public List<Session> getAllSessionsOnDate(LocalDate date) {
		return sessionDatabase.getSessionsOnDate(date);
	}
	
	public List<Session> getSessionsOnDateOfType(LocalDate date, SessionType type) {
		List<Session> allSessionsOnDay = getAllSessionsOnDate(date);
		List<Session> sessionsOfRequiredType = new ArrayList<>();
		for(Session session : allSessionsOnDay) {
			if (session.getSessionType() == type) {
				sessionsOfRequiredType.add(session);
			}
		}
		return sessionsOfRequiredType;
	}
	
}
