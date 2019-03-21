package com.mum.service;

import java.util.List;

import com.mum.model.Location;


public interface LocationService {
	
	Location save(Location location);
	List<Location> saveAll(List<Location> locations);
	Location findById(long id);
	List<Location> findAll();
	long count();
	boolean existsById(Long id);
	List<Location> findByName(String name);

}
