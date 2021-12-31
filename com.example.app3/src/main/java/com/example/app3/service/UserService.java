package com.example.app3.service;

import com.example.app3.entity.User;

public interface UserService {
    int Register(User user);


    User selectOneById(Long id);


}
