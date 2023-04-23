package com.webapi.chatspace.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapi.chatspace.Model.User;
import com.webapi.chatspace.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }

    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User updateUserSpace(long id, User user) {
        Optional<User> updateUser = userRepository.findById(id);
        if(updateUser.isPresent()){
            updateUser.get().setSpaces(user.getSpaces());
            return userRepository.save(updateUser.get());
        }else{
            return null;
        }

        
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    
}
