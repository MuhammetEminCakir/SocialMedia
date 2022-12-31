package com.eren.javaodev.service;

import com.eren.javaodev.entity.Comment;
import com.eren.javaodev.entity.Post;
import com.eren.javaodev.entity.User;
import com.eren.javaodev.mapper.CommentMapper;
import com.eren.javaodev.mapper.PostMapper;
import com.eren.javaodev.repository.CommentRepository;
import com.eren.javaodev.request.CommentRequest;
import com.eren.javaodev.response.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository repository;
    @Autowired
    CommentMapper mapper;

    @Autowired
    PostService postService;
    @Autowired
    PostMapper postMapper;
    @Autowired
    UserService userService;

    public CommentResponse addComment(CommentRequest request) {
        CommentResponse response = new CommentResponse();
        Comment comment = new Comment();
        Post post= postService.repository.findByPostId(request.postId);
        comment.setPost(post);
        User user =userService.repository.getUserByUserId(Integer.valueOf(request.userId));
        comment.setUser(user);
        comment.setText(request.text);
        repository.save(comment);
        response.comment = mapper.toDto((comment));
        return response;
    }

    public CommentResponse updateComment(String commentId, CommentRequest request) {
        CommentResponse response=new CommentResponse();
        Comment comment=repository.findByCommentId(commentId);
        Post post= postService.repository.findByPostId(request.postId);
        comment.setPost(post);
        User user =userService.repository.getUserByUserId(Integer.valueOf(request.userId));
        comment.setUser(user);
        comment.setText(request.text);
        repository.save(comment);
        response.comment = mapper.toDto((comment));
        return response;

    }

    public void deleteComment(String commentId) {
        Comment comment=repository.findByCommentId(commentId);
        repository.delete(comment);
    }








}





