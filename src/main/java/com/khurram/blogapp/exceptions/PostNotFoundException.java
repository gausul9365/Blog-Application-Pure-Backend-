package com.khurram.blogapp.exceptions;


public class PostNotFoundException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;
	

	public PostNotFoundException(String message){
		super(message);
	}
}
