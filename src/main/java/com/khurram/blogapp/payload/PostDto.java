package com.khurram.blogapp.payload;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;



public class PostDto {

	private int id;
	
	@NotBlank(message = "Title is mandatory")
	@Size(min = 5, max = 100, message = "Title should be between 5 and 100 characters.")
	private String title;
	
	@NotBlank(message = "Content is mandetory.")
	private String content;
	
	@NotBlank(message = "Author is mandetory.")
	private String author;
	private String createdAt;	
	
	public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
     // or use Date if you prefer

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


//    public Date getCreatedAt() { return createdAt; }
//    
//    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    
    // no created we are creating DTO only what i want that will be shared ....
}


