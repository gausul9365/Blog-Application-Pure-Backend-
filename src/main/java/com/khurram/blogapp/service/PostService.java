package com.khurram.blogapp.service;


import com.khurram.blogapp.payload.PostDto;

import java.util.List;


public interface PostService {
		
		List<PostDto> getAllPosts();
		
		PostDto getPostById(int id);
		
		PostDto createPost(PostDto postDto);
	  
		PostDto updatePost(int id, PostDto postdto);
	  
		void deletePost(int id);
	  	  
	  
}
