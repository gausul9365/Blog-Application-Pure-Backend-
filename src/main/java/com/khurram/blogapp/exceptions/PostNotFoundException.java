package com.khurram.blogapp.exceptions;


public class PostNotFoundException extends RuntimeException {
	
	public PostNotFoundException(String message){
		super(message);
	}
}
