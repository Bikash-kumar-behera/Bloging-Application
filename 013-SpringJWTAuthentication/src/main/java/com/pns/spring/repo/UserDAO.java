package com.pns.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pns.spring.model.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO, Integer>{
	public UserDTO findByUserName(String name);
}
