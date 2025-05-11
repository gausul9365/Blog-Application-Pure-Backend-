package com.khurram.blogapp.controllers;

import com.khurram.blogapp.payload.PostDto;
import com.khurram.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto) {
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
	