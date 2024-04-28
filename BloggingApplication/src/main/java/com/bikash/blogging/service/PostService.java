package com.bikash.blogging.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bikash.blogging.dao.PostRepository;
import com.bikash.blogging.dao.UserRepository;
import com.bikash.blogging.dto.PostDto;
import com.bikash.blogging.dto.ResponseDto;
import com.bikash.blogging.entity.Comment;
import com.bikash.blogging.entity.Post;
import com.bikash.blogging.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;

	public ResponseDto<?> createPost(String data, MultipartFile postImage) {
		PostDto postDto = null;
		try {
			postDto = new ObjectMapper().readValue(data, PostDto.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Post post = new Post();
		post.setPostTitle(postDto.getPostTitle());
		post.setPostContent(postDto.getPostContent());
		post.setPostCreationTime(LocalDateTime.now());
		post.setCreatedBy(userRepository.findById(postDto.getCreatedBy()).get());
		post.setLikedBy(new ArrayList<>());
		post.setComments(new ArrayList<>());

		String stringPath = "/images/" +System.currentTimeMillis()+ postImage.getOriginalFilename();
		Path path = Paths.get("src/main/resources"+stringPath);
		post.setPostImagePath(stringPath);
		try {
			byte[] bytes = postImage.getBytes();
			Files.write(path, bytes);
			System.out.println(post.getPostImagePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseDto<String> response = new ResponseDto<>();
		response.setData("Post Created with id: " + postRepository.save(post).getPostId());
		response.setMessage("Successful");
		return response;
	}

	public ResponseDto<Post> getPostById(String postId) {
		Post post = postRepository.findById(postId).get();
		ResponseDto<Post> response = new ResponseDto<>();
		response.setData(post);
		response.setMessage("Retrieved Successfully");
		return response;
	}

	public ResponseDto<List<Post>> getAllPosts() {
		ResponseDto<List<Post>> response = new ResponseDto<>();
		response.setMessage("All Posts Retrieved");
		response.setData(postRepository.findAll());
		return response;
	}

	public ResponseDto<List<Post>> getPostsFromFollowings(String userId) {
		User user = userRepository.findById(userId).get();
		List<Post> allPosts = postRepository.findAll();
		List<String> followingIds = user.getFollowings().stream().map(t -> t.getUserId()).toList();
		allPosts = allPosts.stream().filter(post -> followingIds.contains(post.getCreatedBy().getUserId())).toList();

		ResponseDto<List<Post>> response = new ResponseDto<>();
		response.setData(allPosts);
		response.setMessage("Posts from Followings");
		return response;
	}

	public ResponseDto<?> likePost(String postId, String likedBy) {
		Post post = postRepository.findById(postId).get();
		post.getLikedBy().add(userRepository.findById(likedBy).get());
		ResponseDto<String> response = new ResponseDto<>();
		response.setData("Liked Post: " + postId);
		response.setMessage("Successful");
		return response;
	}

	public ResponseDto<?> removeLike(String postId, String userId) {
		Post post = postRepository.findById(postId).get();
		post.getLikedBy().remove(userRepository.findById(userId).get());
		ResponseDto<String> response = new ResponseDto<>();
		response.setData("Removed Like from Post: " + postId);
		response.setMessage("Successful");
		return response;
	}
	
	public ResponseDto<?> createComment(String postId, Comment comment){
		Post post = postRepository.findById(postId).get();
		post.getComments().add(comment);
		postRepository.save(post);
		
		ResponseDto<Post> response = new ResponseDto<>();
		response.setData(post);
		response.setMessage("Comment Created");
		return response;
	}
}
