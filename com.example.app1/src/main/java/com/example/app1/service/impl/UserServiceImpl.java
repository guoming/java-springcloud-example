package com.example.app1.service.impl;

import com.example.app1.dao.UserDao;
import com.example.app1.entity.User;
import com.example.app1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserServiceImpl")
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userdao;



    @Override
    public int Register(User user) {
        log.info(user.getName());
        return userdao.insert(user);
    }

    @Override
    public User selectOneById(Long id) {

        log.info("selectById:"+id);
        return userdao.selectOneById(id);


    }
}
