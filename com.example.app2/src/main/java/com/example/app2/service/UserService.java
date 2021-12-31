package com.example.app2.service;

import com.example.app2.entity.User;

public interface UserService {
    int Register(User user);


    User selectOneById(Long id);


}
