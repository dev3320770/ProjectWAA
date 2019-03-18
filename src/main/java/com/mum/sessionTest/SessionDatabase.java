package com.mum.sessionTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mum.model.Session;
import com.mum.model.Session.SessionBuilder;
import com.mum.model.SessionType;

public class SessionDatabase {
	
	private static List<Session> sessions;
	
	SessionDatabase() {
		sessions = new ArrayList<>();
	}

	public static List<Session> generateSessions(int month) {
		
		List<Session> monthSessions = new ArrayList<>();
		
		for(int day = 1; day <= 22; ++day) {
			LocalDate sessionDate = LocalDate.of(2019,month,day);
			LocalDateTime startTime = LocalDateTime.of(2019,month,day,9,45);
			Long id = (long)2019*1000+month*100+day;
			
			Session session =  new SessionBuilder()
						.withId(id)
						.withDate(sessionDate)
						.withStartTime(startTime)
						.withType(SessionType.MORNING_MEDITATION)
						.build();
			monthSessions.add(session);
			updateDatabase(session);
		}
		return monthSessions;
	}

	private static void updateDatabase(Session newSession) {
		// TODO Auto-generated method stub
		for(Session session : sessions) {
			if (session.getId() == newSession.getId())
				return;
		}
		sessions.add(newSession);
	}
	
	public List<Session> getAllSessions() {
		return sessions;
	}
	
	public Session findById(Long id) {
		for (Session session : sessions) {
			if(session.getId() == id)
				return session;
		}
		return null;
	}
	
	public List<Session> getSessionsOnDate(LocalDate date) {
		List<Session> sessionsOnSpecifiedDay = new ArrayList<>();
		for (Session session : sessions) {
			LocalDate sessionDate = session.getSessionDate();
			if (isSameDay(sessionDate, date)) {
				sessionsOnSpecifiedDay.add(session);
			}
		}
		return sessionsOnSpecifiedDay;
	}

	private boolean isSameDay(LocalDate sessionDate, LocalDate date) {
		return sessionDate.getDayOfMonth() == date.getDayOfMonth()
				&& sessionDate.getMonth() == date.getMonth()
				&& sessionDate.getYear() == date.getYear();
	}
	
}
