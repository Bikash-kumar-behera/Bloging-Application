package com.bikash.blogging.dto;

import lombok.Data;

@Data
public class PostDto {
	private String postTitle;
	private String postContent;
	private String createdBy;
}
