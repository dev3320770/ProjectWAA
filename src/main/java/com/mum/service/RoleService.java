package com.mum.service;

import com.mum.model.Role;

public interface RoleService {
	public void save(Role role);
	public Role getRole(String type);
}
