package com.khurram.blogapp.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "post_title", nullable = false, length = 100)
	private String title;
	
	@Column(length = 10000)
	private String content;
	
	private String author;
	
	private Date createdAt;
	public Post() {};
	
	public Post(int id, String title, String content, String author, Date createdAt) {
		this.id = id;
		this.title= title;
		this.content = content;
		this.author = author;
		this.createdAt = createdAt;
	}
	
		public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getTitle() { return title; }
	    public void setTitle(String title) { this.title = title; }

	    public String getContent() { return content; }
	    public void setContent(String content) { this.content = content; }

	    public String getAuthor() { return author; }
	    public void setAuthor(String author) { this.author = author; }

	    public Date getCreatedAt() { return createdAt; }
	    
	    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
	
}
