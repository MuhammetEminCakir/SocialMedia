package com.eren.javaodev.controller;

import com.eren.javaodev.request.CommentRequest;
import com.eren.javaodev.response.CommentResponse;
import com.eren.javaodev.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
public class CommentController {
    @Autowired
    CommentService service;


    @PostMapping("/add")
    public CommentResponse addComment(@RequestBody CommentRequest request){
        return service.addComment(request);
    }

    @PutMapping("update/{commentId}")
    public CommentResponse updateComment(@PathVariable String commentId, @RequestBody CommentRequest request) {
        return service.updateComment(commentId, request);
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable (name = "commentId")String commentId){
        service.deleteComment(commentId);
    }
}
