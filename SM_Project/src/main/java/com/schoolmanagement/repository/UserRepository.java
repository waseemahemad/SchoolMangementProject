package com.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagement.entity.User;

public interface UserRepository 
			extends JpaRepository<User,Integer> {
   //User findByUserName(String username);
   User findByName(String name);
}
