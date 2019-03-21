package com.mum.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session,Long>{
	
	public final String GET_ALL_SESSIONS_IN_BLOCK = "select * from session where block_id = ?1";
	
	@Query("SELECT s FROM Session s where s.block.id = ?1")
	public List<Session> getAllSessionInBlock(long blockId);

	
	
	@Query("SELECT s FROM Session s where s.sessionDate = ?1")
	public List<Session> findSessionBySessionDate(LocalDate sessionDate);
	
	
}
