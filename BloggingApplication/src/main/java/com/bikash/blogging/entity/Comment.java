package com.bikash.blogging.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "column_id")
	private String commentId;
	private String commentText;
	private String commenterId;
}
