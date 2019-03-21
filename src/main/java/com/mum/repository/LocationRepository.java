package com.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}
