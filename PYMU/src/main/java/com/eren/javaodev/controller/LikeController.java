package com.eren.javaodev.controller;

import com.eren.javaodev.request.LikeRequest;
import com.eren.javaodev.response.LikeResponse;
import com.eren.javaodev.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("likes")
public class LikeController {
    @Autowired
    LikeService service;

    @PostMapping("/add")
    public LikeResponse addLike (@RequestBody LikeRequest request){
        return service.addLike(request);
    }

    @DeleteMapping("/delete/{likeId}")
    public void deleteLike(@PathVariable (name = "likeId")String likeId){
        service.deleteLike(likeId);
    }



    @GetMapping("/listAll")
    public List<LikeResponse> listAll() {
        return service.listAll();
    }
}
