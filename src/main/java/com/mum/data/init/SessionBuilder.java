package com.mum.data.init;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mum.model.Block;
import com.mum.model.Session;
import com.mum.model.SessionType;

public class SessionBuilder {
	private Session session;
	
	public SessionBuilder() {
		session = new Session();
	}
	
	public SessionBuilder withId(Long id) {
		session.setId(id);
		return this;
	}
	
	public SessionBuilder withDate(LocalDate sessionDate) {
		session.setSessionDate(sessionDate);
		return this;
	}
	
	public SessionBuilder withStartTime(LocalDateTime sessionStartTime) {
		session.setSessionStartTime(sessionStartTime);
		return this;
	}
	
//	public SessionBuilder withEndTime(LocalDate sessionEndTime) {
//		session.setSessionEndTime(sessionEndTime);
//		return this;
//	}
	
	public SessionBuilder withType(SessionType type) {
		session.setSessionType(type);
		return this;
	}
	
	public SessionBuilder inBlock(Block block) {
		session.setSessionBlock(block);
		return this;
	}
	
	public Session build() {
		return session;
	}

	public SessionBuilder withBlock(Block block) {
		// TODO Auto-generated method stub
		return null;
	}
	
}	    
