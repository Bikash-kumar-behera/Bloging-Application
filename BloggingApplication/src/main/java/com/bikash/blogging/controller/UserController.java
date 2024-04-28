package com.bikash.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikash.blogging.entity.User;
import com.bikash.blogging.service.UserService;

@RestController
@RequestMapping(path = "user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") String userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		
		return userService.createUser(user);
	}
	
	@PostMapping("/{id}/follow")
	public User followUser(@PathVariable("id") String userId, @RequestParam("followingId") String followingId) {
		return userService.addFollowing(userId, followingId);
	}
	
	@GetMapping("/{id}/followings")
	public List<User> getFollowings(@PathVariable("id")String userId) {
		return userService.getFollowings(userId);
	}
}
