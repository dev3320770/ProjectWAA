package com.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Location;
import com.mum.model.Session;
import com.mum.model.SessionTransaction;
import com.mum.model.Student;
import com.mum.repository.SessionTransactionRepository;
import com.mum.service.SessionTransactionService;
@Service
public class SessionTransactionServiceImpl implements SessionTransactionService{

	@Autowired
	SessionTransactionRepository  sessionTransactionRepository;
	
	@Override
	public SessionTransaction save(SessionTransaction sessionTransaction) {
		// TODO Auto-generated method stub
		return sessionTransactionRepository.save(sessionTransaction);
	}

	@Override
	public List<SessionTransaction> saveAll(List<SessionTransaction> sessionTransactions) {
		// TODO Auto-generated method stub
		return (List<SessionTransaction>) sessionTransactionRepository.saveAll(sessionTransactions);
	}

	@Override
	public SessionTransaction findById(long id) {
		// TODO Auto-generated method stub
		return sessionTransactionRepository.findById(id).get();
	}

	@Override
	public List<SessionTransaction> findAll() {
		// TODO Auto-generated method stub
		return (List<SessionTransaction>) sessionTransactionRepository.findAll();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return sessionTransactionRepository.count();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return sessionTransactionRepository.existsById(id);
	}

	@Override
	public List<SessionTransaction> findByStudentId(String id) {
		// TODO Auto-generated method stub
		return (List<SessionTransaction>) sessionTransactionRepository.findByStudentId(id);
	}
	
	@Override
	public SessionTransaction createTransaction(Student student, Session session, Location location) {
		SessionTransaction sessionTransaction = new SessionTransaction();
		sessionTransaction.setStudent(student);
		sessionTransaction.setSession(session);
		sessionTransaction.setCheckinDate(session.getSessionDate());
		sessionTransaction.setLocation(location);
		return sessionTransaction;
	}
}
