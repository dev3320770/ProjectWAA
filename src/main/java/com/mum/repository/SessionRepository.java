package com.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {

}
