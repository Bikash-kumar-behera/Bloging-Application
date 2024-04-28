package com.bikash.blogging.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.blogging.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
}
