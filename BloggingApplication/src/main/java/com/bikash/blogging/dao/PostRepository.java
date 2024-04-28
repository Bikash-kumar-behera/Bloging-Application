package com.bikash.blogging.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.blogging.entity.Post;

public interface PostRepository extends JpaRepository<Post, String>{
	
}
