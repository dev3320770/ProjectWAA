package com.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Location;
import com.mum.repository.LocationRepository;
import com.mum.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepository;
	
	@Override
	public Location save(Location location) {
		// TODO Auto-generated method stub
		return locationRepository.save(location);
	}

	@Override
	public List<Location> saveAll(List<Location> locations) {
		// TODO Auto-generated method stub
		return (List<Location>) locationRepository.saveAll(locations);
	}

	@Override
	public Location findById(long id) {
		// TODO Auto-generated method stub
		return locationRepository.findById(id).get();
	}

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return (List<Location>) locationRepository.findAll();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return locationRepository.count();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return locationRepository.existsById(id);
	}

	@Override
	public List<Location> findByName(String name) {
		// TODO Auto-generated method stub
		return	locationRepository.findByName(name);
	}
	
	

}
