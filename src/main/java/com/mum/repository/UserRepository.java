package com.mum.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.model.User;


@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
//    User findByEmail(String email);
    User findByUsername(String username);
}