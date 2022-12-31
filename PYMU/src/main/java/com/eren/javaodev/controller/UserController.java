package com.eren.javaodev.controller;

import com.eren.javaodev.request.UserRequest;
import com.eren.javaodev.response.UserResponse;
import com.eren.javaodev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request){
        return userService.register(request);
    }

    @GetMapping("/login/{email}/{password}")
    public UserResponse login(@PathVariable(value = "email")String email,
                              @PathVariable(value = "password")String password){
        UserResponse userResponse= userService.login(email,password);
        return userResponse;
    }
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable (name = "userId")String userId){
        userService.deleteUser(userId);
    }

    ///
    @GetMapping("/find/{userId}")
    public UserResponse findUser(@PathVariable(name = "userId")String userId){
        return userService.findUser(userId);
    }

    @GetMapping("/listAll")
    public List<UserResponse> listAll(){
        return userService.listAll();
    }

    @PutMapping("update/{userId}")
    public UserResponse updateUser(@PathVariable String userId,@RequestBody UserRequest request){
        return userService.updateUser(userId,request);
    }
}
