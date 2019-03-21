package com.mum.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mum.model.Role;
import com.mum.model.User;
import com.mum.repository.RoleRepository;
import com.mum.repository.UserRepository;

public interface UserService {
    public User findUserByUsername(String username);
    public User saveUser(User user);
    public User createUser(String firstName, String lastName);
}