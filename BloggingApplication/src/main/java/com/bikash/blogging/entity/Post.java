package com.bikash.blogging.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String postId;
	private String postTitle;
	private String postImagePath;
	@Column(columnDefinition = "TEXT")
	private String postContent;
	private LocalDateTime postCreationTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "user_id",name = "created_by")
	private User createdBy;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "post_user", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> likedBy;
	
	@OneToMany(mappedBy = "commentId", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Comment> comments;
}
