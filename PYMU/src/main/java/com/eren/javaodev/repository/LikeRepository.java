package com.eren.javaodev.repository;

import com.eren.javaodev.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Integer> {
    Like findByLikeId(String likeId);
}
