package com.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.model.Role;
import com.mum.repository.RoleRepository;
import com.mum.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role getRole(String type) {
		type = type.toLowerCase();
		switch(type) {
			case "admin":
				return roleRepository.findById(1).get();
			case "faculty":
				return roleRepository.findById(2).get();
			case "student":
				return roleRepository.findById(3).get();
			default:
				return roleRepository.findById(1).get();
		}
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}
}
