package com.mum.service;

import java.util.List;

import com.mum.model.SessionTransaction;


public interface SessionTransactionService {
	
	SessionTransaction save(SessionTransaction sessionTransaction);
	List<SessionTransaction> saveAll(List<SessionTransaction> sessionTransactions);
	SessionTransaction findById(long id);
	List<SessionTransaction> findAll();
	List<SessionTransaction> findByStudentId(Long id);
	long count();
	boolean existsById(Long id);

}
