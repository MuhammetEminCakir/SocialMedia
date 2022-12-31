package com.eren.javaodev.repository;

import com.eren.javaodev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailEqualsAndPasswordEquals(String email,String password);

    User getUserByUserId(Integer integer);

    User findUserByEmail(String email);

    User findByUserId(Integer valueOf);

}
