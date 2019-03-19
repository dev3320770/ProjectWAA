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
import com.mum.repository.BlockRepository;
import com.mum.repository.SessionRepository;
import com.mum.service.SessionService;
@Service
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired 
	private BlockRepository blockRepository;

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
		return sessionRepository.findById(id).get();
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
	
	
	// -------------------------- DATA GENERATOR --------------------------------- //
	
	
	

}
