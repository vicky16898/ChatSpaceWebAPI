package com.webapi.chatspace.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.chatspace.Model.User;
import com.webapi.chatspace.Service.SequenceGeneratorService;
import com.webapi.chatspace.Service.UserService;

@RestController
public class UserController{
    @Autowired
    UserService userService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
    
    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        return userService.saveUser((user));
    }

    @PutMapping("/user/{id}/space")
    public User updateUserSpace(@PathVariable long id, @RequestBody User user){
        return userService.updateUserSpace(id, user);
    }
}