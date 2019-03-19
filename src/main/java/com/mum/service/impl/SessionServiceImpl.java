package com.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Session;
import com.mum.repository.SessionRepository;
import com.mum.service.SessionService;
@Service
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	SessionRepository sessionRepository;

	@Override
	public Session save(Session session) {
		// TODO Auto-generated method stub
		return sessionRepository.save(session);
	}

	@Override
	public List<Session> saveAll(List<Session> sessions) {
		// TODO Auto-generated method stub
		return (List<Session>) sessionRepository.saveAll(sessions);
	}

	@Override
	public Session findById(long id) {
		// TODO Auto-generated method stub
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
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return sessionRepository.existsById(id);
	}

}
