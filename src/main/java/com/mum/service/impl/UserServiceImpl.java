package com.mum.service.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mum.model.Role;
import com.mum.model.User;
import com.mum.repository.RoleRepository;
import com.mum.repository.UserRepository;
import com.mum.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(1);
//        Role r= new Role();
//        r.setRole("ADMIN");
//        roleRepository.save(r);
//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
    
    public User createUser(String firstName, String lastName) {
    	User user = new User();
    	user.setFirstName(firstName);
    	user.setLastName(lastName);
    	
    	String username = (firstName.charAt(0) + lastName).toLowerCase();
    	String password = "12345";
    	
    	user.setEmail(username + "@mum.edu");
    	user.setUsername(username);
    	user.setPassword(bCryptPasswordEncoder.encode(password));
    	return user;
    }

	

}