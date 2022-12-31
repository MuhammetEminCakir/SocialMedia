package com.eren.javaodev.controller;

import com.eren.javaodev.request.PostRequest;
import com.eren.javaodev.response.PostResponse;
import com.eren.javaodev.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {
    @Autowired
    PostService service;


    @PostMapping("/add")
    public PostResponse addPost(@RequestBody PostRequest request){
        return  service.addPost(request);
    }

    @PutMapping("update/{postId}")
    public PostResponse updatePost(@PathVariable String postId, @RequestBody PostRequest request) {
        return service.updatePost(postId, request);
    }

    @DeleteMapping("/delete/{postId}")
    public void deletePost(@PathVariable (name = "postId")String postId){
        service.deletePost(postId);
    }

    @GetMapping("/listAll")
    public List<PostResponse> listAll() {
        return service.listAll();
    }
}
