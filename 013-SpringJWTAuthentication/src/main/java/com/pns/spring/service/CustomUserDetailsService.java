package com.pns.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pns.spring.model.UserDTO;
import com.pns.spring.repo.UserDAO;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO userDTO = userDAO.findByUserName(username);
		return new User(userDTO.getUserName(),userDTO.getPassWord(),new ArrayList<>());
	}

}
