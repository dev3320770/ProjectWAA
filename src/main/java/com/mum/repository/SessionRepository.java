package com.mum.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session,Long>{
	
	//@Query()
	//List<Session> getAllSessionInBlock(long id);

}
