package com.khurram.blogapp.service.impl;

import com.khurram.blogapp.entities.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import com.khurram.blogapp.exceptions.PostNotFoundException;
import com.khurram.blogapp.payload.PostDto;
import com.khurram.blogapp.payload.PostResponse;
import com.khurram.blogapp.repositories.PostRepository;
import com.khurram.blogapp.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;





@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    //  GET ALL POSTS - MAP ENTITY -> DTO
  
    @Override
    public PostResponse getAllPosts(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        Page<Post> postPage = postRepository.findAll(pageable);
        
        List<Post> posts = postPage.getContent();
        List<PostDto> content = posts.stream().map(this::mapToDto).toList();

        PostResponse response = new PostResponse();
        response.setContent(content);
        response.setPageNumber(postPage.getNumber());
        response.setPageSize(postPage.getSize());
        response.setTotalElements(postPage.getTotalElements());
        response.setTotalPages(postPage.getTotalPages());
        response.setLastPage(postPage.isLast());

        return response;
    }

    //  GET POST BY ID
    @Override
    public PostDto getPostById(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post with ID " + id + " not found."));
        return mapToDto(post);
    }

    //  CREATE POST
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto); // convert DTO → Entity
        Post savedPost = postRepository.save(post);
        return mapToDto(savedPost); // return Entity → DTO
    }

    //  UPDATE POST
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

    // DELETE POST
    @Override
    public void deletePost(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post with ID " + id + " not found."));
        postRepository.delete(post);
    }

    //  MAP ENTITY → DTO
    private PostDto mapToDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setAuthor(post.getAuthor());
        dto.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(post.getCreatedAt()));
        return dto;
    }


    //  MAP DTO → ENTITY
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
