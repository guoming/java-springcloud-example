package com.example.app1.service;

import com.example.app1.entity.User;

public interface UserService {
    int Register(User user);


    User selectOneById(Long id);


}
