package com.mum.service;

import java.util.List;

import com.mum.model.Session;


public interface SessionService {
	
	Session save(Session session);
	List<Session> saveAll(List<Session> sessions);
	Session findById(long id);
	List<Session> findAll();
	long count();
	boolean existsById(Long id);

}
