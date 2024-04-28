package com.bikash.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bikash.blogging.dto.ResponseDto;
import com.bikash.blogging.entity.Comment;
import com.bikash.blogging.service.PostService;

@RestController
@RequestMapping(path = "post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/")
	public ResponseDto<?> createPost(@RequestParam("data") String data, @RequestParam("image") MultipartFile postImage) {
		return postService.createPost(data, postImage);
	}
	
	@GetMapping("/all")
	public ResponseDto<?> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public ResponseDto<?> getPostById(@PathVariable("id") String postId){
		return postService.getPostById(postId);
	}
	
	@GetMapping("/followings/{userId}")
	public ResponseDto<?> getPostFromFollowing(@PathVariable("userId") String userId){
		return postService.getPostsFromFollowings(userId);
	}
	
	@PostMapping("/{id}/comment")
	public ResponseDto<?> createComment(@PathVariable("id") String postId, @RequestBody Comment comment){
		return postService.createComment(postId, comment);
	}
	
	@PostMapping("/{id}/like")
	public ResponseDto<?> doLike(@PathVariable("id")String postId, @RequestParam("userId")String userId){
		return postService.likePost(postId, userId);
	}
	
	@PostMapping("/{id}/removeLike")
	public ResponseDto<?> undoLike(@PathVariable("id")String postId, @RequestParam("userId")String userId){
		return postService.removeLike(postId, userId);
	}
	
}
