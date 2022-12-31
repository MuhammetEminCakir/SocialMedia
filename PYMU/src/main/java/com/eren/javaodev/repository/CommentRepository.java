package com.eren.javaodev.repository;

import com.eren.javaodev.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    Comment findByCommentId(String commentId);
}
