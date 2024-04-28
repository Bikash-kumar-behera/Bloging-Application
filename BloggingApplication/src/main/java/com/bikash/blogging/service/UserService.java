package com.bikash.blogging.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.blogging.dao.UserRepository;
import com.bikash.blogging.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	public User getUserById(String userId) {
		return userRepository.findById(userId).get();
	}
	
	public User createUser(User user) {
		user.setFollowings(new ArrayList<>());
		return userRepository.save(user);
	}
	
	public User addFollowing(String userId, String followingId) {
		User user = userRepository.findById(userId).get();
		User toBeFollowed = userRepository.findById(followingId).get();
		user.getFollowings().add(toBeFollowed);
		return userRepository.save(user);
	}
		
	public List<User> getFollowings(String userId){
		return userRepository.findById(userId).get().getFollowings();
	}
}
