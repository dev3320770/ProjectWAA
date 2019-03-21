package com.mum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.SessionTransaction;
import com.mum.model.Student;

@Repository
public interface SessionTransactionRepository extends CrudRepository<SessionTransaction, Long> {
	
	@Query(value="SELECT * FROM Session_Transaction  WHERE student_id = ?1", nativeQuery = true)
	Student findByStudentId(long id);

}
