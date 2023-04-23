package com.webapi.chatspace.Service;


import java.util.List;

import com.webapi.chatspace.Model.User;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(long id);
    User saveUser(User user);

    //update
    User updateUserSpace(long id, User user);

    
}
