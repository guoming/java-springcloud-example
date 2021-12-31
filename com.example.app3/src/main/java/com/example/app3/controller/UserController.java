package com.example.app3.controller;

import com.example.app3.command.commandResult;
import com.example.app3.entity.User;
import com.example.app3.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@Slf4j
public class UserController {

    @Resource
            @Qualifier("UserServiceImpl")
    UserService userService2;

    @Resource
    RestTemplate restTemplate;

    @PostMapping("/user/register")
    public int Register(@RequestBody User user)
    {
        log.info("用户注册");
       return userService2.Register(user);
    }

    @GetMapping("/user/{type}/{id}")
    public commandResult select(@PathVariable(name = "id",required = true) String id2,@PathVariable String type)
    {
        User user= userService2.selectOneById(Long.valueOf(id2));

        return new commandResult("200","成功", user);
    }
}
