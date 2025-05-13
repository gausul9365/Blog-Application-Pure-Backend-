package com.khurram.blogapp.controllers;

import com.khurram.blogapp.payload.PostDto;
import com.khurram.blogapp.payload.PostResponse;

import jakarta.validation.Valid;
	
import com.khurram.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        return postService.getAllPosts(page, size);
    }



    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public PostDto createPost(@Valid @RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable int id, @RequestBody PostDto postDto) {
        return postService.updatePost(id, postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }
}
	