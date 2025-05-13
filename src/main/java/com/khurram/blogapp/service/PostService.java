package com.khurram.blogapp.service;


import com.khurram.blogapp.payload.PostDto;
import com.khurram.blogapp.payload.PostResponse;

import java.util.List;


public interface PostService {
		
		PostResponse getAllPosts(int pageNumber, int pageSize);

		
		PostDto getPostById(int id);
		
		PostDto createPost(PostDto postDto);
	  
		PostDto updatePost(int id, PostDto postdto);
	  
		void deletePost(int id);
	  	  
	  
}
