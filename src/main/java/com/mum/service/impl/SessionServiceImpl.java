package com.mum.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Session;
import com.mum.repository.SessionRepository;
import com.mum.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public Session save(Session session) {
		// TODO Auto-generated method stub
		System.out.println("Calling repository save method ..... ");
		return sessionRepository.save(session);
	}

	@Override
	public List<Session> saveAll(List<Session> sessions) {
		// TODO Auto-generated method stub
		return (List<Session>) sessionRepository.saveAll(sessions);
	}

	@Override
	public Session findSessionById(long id) {
		Optional<Session> sessionOptional = sessionRepository.findById(id);
		if (sessionOptional.isPresent())
			return sessionOptional.get();
		return null;
	}

	@Override
	public List<Session> findAll() {
		// TODO Auto-generated method stub
		return (List<Session>) sessionRepository.findAll();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return sessionRepository.count();
	}

	@Override
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		return sessionRepository.existsById(id);
	}
	
	@Override
	public List<Session> getAllSessionsInBlock (long blockId) {
		return sessionRepository.getAllSessionInBlock(blockId);
	}
	@Override
	public List<Session> findSessionBySessionDate(LocalDate sessionDate) {
		return sessionRepository.findSessionBySessionDate(sessionDate);
		
	}
	// -------------------------- DATA GENERATOR --------------------------------- //
	
	
	

}
