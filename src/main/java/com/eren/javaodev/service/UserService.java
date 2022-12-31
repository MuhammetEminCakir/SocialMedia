package com.eren.javaodev.service;

import com.eren.javaodev.entity.User;
import com.eren.javaodev.mapper.UserMapper;
import com.eren.javaodev.repository.UserRepository;
import com.eren.javaodev.request.UserRequest;
import com.eren.javaodev.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;
    public UserResponse register(UserRequest request) {
        UserResponse userResponse=new UserResponse();
        User user= new User();
        user.setName(request.name);
        user.setSurname(request.surname);
        user.setEmail(request.email);
        user.setUserName(request.userName);
        user.setImgUrl(request.imgUrl);
        user.setPostList(new ArrayList<>());
        user.setPassword(request.password);
        user=repository.save(user);
        userResponse.user=mapper.toDto(user);
        return userResponse;
    }
    public UserResponse login(String email, String password) {
        UserResponse userResponse= new UserResponse();
        User user = repository.findUserByEmail(email);
        if (!user.getPassword().equals(password)){
            return null;
        }
        userResponse.user = mapper.toDto(user);
        return userResponse;
    }

    public void deleteUser(String id) {
        User user= repository.getUserByUserId(Integer.valueOf(id));
        repository.delete(user);
    }

    public UserResponse findUser(String userId) {
        UserResponse userResponse=new UserResponse();
        User user = repository.findByUserId(Integer.valueOf(userId));
        userResponse.user=mapper.toDto(user);
        return userResponse;
    }

    public List<UserResponse> listAll() {
        List<UserResponse>userResponseList=new ArrayList<>();
        for (int i = 0; i <repository.findAll().size(); i++) {
            User user =repository.findAll().get(i) ;
            UserResponse response=new UserResponse();
            response.user=mapper.toDto(user);
            userResponseList.add(response);
        }
        return userResponseList;
    }

    public UserResponse updateUser(String userId, UserRequest request) {
        UserResponse response= new UserResponse();
        User user =repository.findByUserId(Integer.valueOf(userId));
        user.setUserName(request.userName);
        user.setPassword(request.password);
        user.setName(request.name);
        user.setSurname(request.surname);
        user.setEmail(request.email);
        user.setImgUrl(request.imgUrl);
        repository.save(user);
        response.user= mapper.toDto(user);
        return response;

    }
}
