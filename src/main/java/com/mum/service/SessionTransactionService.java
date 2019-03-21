package com.mum.service;

import java.util.List;

import com.mum.model.Location;
import com.mum.model.Session;
import com.mum.model.SessionTransaction;
import com.mum.model.Student;


public interface SessionTransactionService {
	
	public SessionTransaction save(SessionTransaction sessionTransaction);
	public List<SessionTransaction> saveAll(List<SessionTransaction> sessionTransactions);
	public SessionTransaction findById(long id);
	public List<SessionTransaction> findAll();
	public List<SessionTransaction> findByStudentId(Long id);
	public long count();
	public boolean existsById(Long id);
	public SessionTransaction createTransaction(Student student, Session session, Location location);

}
