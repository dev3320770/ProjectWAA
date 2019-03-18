package com.mum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Block;
import com.mum.model.Session;
import com.mum.repository.SessionRepository;
import com.mum.sessionTest.MockSessionRepository;

@Service
public class SessionService {
	
	@Autowired 
	private SessionRepository sessionRepository;
	
	@Autowired
	private MockSessionRepository mockRepository;
	
	public Session getSessionByID(Long id) {
		
		return mockRepository.findById(id);
		
		//return sessionRepository.findById(id).get();
	}
	
	// get all sessions in block
	public List<Session> getAllSessionsInBlock (Long blockId) {
		
		return mockRepository.getAllSessionsInBlock(blockId);
		
		//return sessionRepository.getAllSessionInBlock(block.getId());
	}
	
	// get sessiontransactions for session
	
	// get all sessions in block by type
	
	
}
