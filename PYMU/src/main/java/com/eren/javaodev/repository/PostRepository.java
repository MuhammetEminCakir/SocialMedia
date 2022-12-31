package com.eren.javaodev.repository;

import com.eren.javaodev.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
    Post findByPostId(String postId);
}
