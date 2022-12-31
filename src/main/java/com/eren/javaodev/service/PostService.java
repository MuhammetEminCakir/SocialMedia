package com.eren.javaodev.service;

import com.eren.javaodev.dto.PostDto;
import com.eren.javaodev.entity.Post;
import com.eren.javaodev.entity.User;
import com.eren.javaodev.mapper.PostMapper;
import com.eren.javaodev.repository.PostRepository;
import com.eren.javaodev.request.PostRequest;
import com.eren.javaodev.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository repository;

    @Autowired
    PostMapper mapper;
    @Autowired
    UserService userService;


    public PostResponse addPost(PostRequest request) {
        PostResponse response= new PostResponse();
        Post post=new Post();
        post.setTitle(request.title);
        post.setText(request.text);
        User user= userService.repository.findByUserId(Integer.valueOf(request.userId));
        post.setUser(user);
        repository.save(post);
        response.post=toPostDto(post);
        return response;
    }


    private PostDto toPostDto(Post post){
        PostDto dto= new PostDto();
        dto.postId= post.getPostId();
        dto.text= post.getText();
        dto.title=post.getTitle();
        dto.postId=post.getPostId();
        return dto;
    }

    public PostResponse updatePost(String postId, PostRequest request) {
        PostResponse response=new PostResponse();
        Post post=repository.findByPostId(postId);
        post.setText(request.text);
        post.setTitle(request.title);
        User user= userService.repository.findByUserId(Integer.valueOf(request.userId));
        post.setUser(user);
        repository.save(post);
        response.post= mapper.toDto(post);
        return response;
    }

    public List<PostResponse> listAll() {
        List<PostResponse>postResponseList=new ArrayList<>();
        for (int i = 0; i <repository.findAll().size(); i++) {
            Post post =repository.findAll().get(i) ;
            PostResponse response=new PostResponse();
            response.post=mapper.toDto(post);
            postResponseList.add(response);
        }
        return postResponseList;
    }


    public void deletePost(String postId) {
        Post post=repository.findByPostId(postId);
        repository.delete(post);
    }

}
