package com.mum.service;

import java.time.LocalDate;
import java.util.List;

import com.mum.model.Session;


public interface SessionService {
	
	public Session save(Session session);
	public List<Session> saveAll(List<Session> sessions);
	public Session findSessionById(long id);
	public List<Session> findAll();
	public long count();
	public boolean existsById(long id);
	public List<Session> getAllSessionsInBlock(long blockId);
	
	public List<Session> findSessionBySessionDate(LocalDate sessionDate);
	// --- Data Generator ---//
}
