package com.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.SessionTransaction;

@Repository
public interface SessionTransactionRepository extends CrudRepository<SessionTransaction, Long> {

}
