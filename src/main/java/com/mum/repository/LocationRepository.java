package com.mum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
	@Query("SELECT l FROM Location l where l.name = ?1")
	public List<Location> findByName(String name);
}
