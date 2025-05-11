package com.khurram.blogapp.service.impl;

import com.khurram.blogapp.entities.Post;
import com.khurram.blogapp.exceptions.PostNotFoundException;
import com.khurram.blogapp.payload.PostDto;
import com.khurram.blogapp.repositories.PostRepository;
import com.khurram.blogapp.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    // 🔁 GET ALL POSTS - MAP ENTITY -> DTO
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // 🎯 GET POST BY ID
    @Override
    public PostDto getPostById(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post with ID " + id + " not found."));
        return mapToDto(post);
    }

    // 🆕 CREATE POST
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto); // convert DTO → Entity
        Post savedPost = postRepository.save(post);
        return mapToDto(savedPost); // return Entity → DTO
    }

    // ✏️ UPDATE POST
    @Override
    public PostDto updatePost(int id, PostDto postDto) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post with ID " + id + " not found."));

        existingPost.setTitle(postDto.getTitle());
        existingPost.setContent(postDto.getContent());
        existingPost.setAuthor(postDto.getAuthor());
        // Skipping createdAt update — usually auto-managed

        Post updatedPost = postRepository.save(existingPost);
        return mapToDto(updatedPost);
    }

    // ❌ DELETE POST
    @Override
    public void deletePost(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post with ID " + id + " not found."));
        postRepository.delete(post);
    }

    // 🧠 MAP ENTITY → DTO
    private PostDto mapToDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setAuthor(post.getAuthor());
        dto.setCreatedAt(post.getCreatedAt().toString()); // Optional format
        return dto;
    }

    // 🧠 MAP DTO → ENTITY
    private Post mapToEntity(PostDto dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setAuthor(dto.getAuthor());
        post.setCreatedAt(new java.util.Date()); // OR parse from dto if needed
        return post;
    }
}
