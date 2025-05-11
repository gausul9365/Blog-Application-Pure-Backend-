package com.khurram.blogapp.payload;



public class PostDto {

	private int id;
	private String title;
	private String content;
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
