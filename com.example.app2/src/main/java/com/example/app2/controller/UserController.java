package com.example.app2.controller;

import com.example.app2.command.commandResult;
import com.example.app2.entity.User;
import com.example.app2.service.UserService;
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
        ResponseEntity<commandResult> responseEntityResponseEntity = restTemplate.getForEntity(
                "http://app3/user/app3/"+id2, commandResult.class);

        return responseEntityResponseEntity.getBody();
    }
}
