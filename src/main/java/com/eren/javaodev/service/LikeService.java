package com.eren.javaodev.service;

import com.eren.javaodev.entity.Like;
import com.eren.javaodev.entity.Post;
import com.eren.javaodev.entity.User;
import com.eren.javaodev.mapper.LikeMapper;
import com.eren.javaodev.repository.LikeRepository;
import com.eren.javaodev.request.LikeRequest;
import com.eren.javaodev.response.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikeService {
    @Autowired
    LikeRepository repository;
    @Autowired
    LikeMapper mapper;
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;


    public LikeResponse addLike(LikeRequest request) {
        LikeResponse response=new LikeResponse();
        Like like= new Like();
        User user =userService.repository.findByUserId(Integer.valueOf(request.userId));
        like.setUser(user);
        Post post=postService.repository.findByPostId(request.postId);
        like.setPost(post);
        repository.save(like);
        response.like=mapper.toDto(like);
        return response;
    }

    public void deleteLike(String likeId) {
        Like like=repository.findByLikeId(likeId);
        repository.delete(like);
    }

    public List<LikeResponse> listAll() {
        List<LikeResponse>likeResponseList=new ArrayList<>();
        for (int i = 0; i <repository.findAll().size(); i++) {
            Like like =repository.findAll().get(i) ;
            LikeResponse response=new LikeResponse();
            response.like=mapper.toDto(like);
            likeResponseList.add(response);
        }
        return likeResponseList;
    }
}
