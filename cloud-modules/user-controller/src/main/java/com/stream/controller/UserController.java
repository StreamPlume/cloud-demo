package com.stream.controller;

import com.stream.model.entity.UserEntity;
import com.stream.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Stream on 2018/7/5.
 */
@Slf4j
@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/info/{id}")
    public UserEntity queryUser(@PathVariable Long id){

        log.info("queryUser");
        UserEntity user;
        user = userService.queryUser(id);
        return user;
    }

    @PostMapping("/queryUserController")
    public UserEntity queryUserController(){

        log.info("queryUser");
        UserEntity user = userService.queryUserService();

        return user;
    }

    @GetMapping("/queryAll")
    public List<UserEntity> queryAll(){
        return userService.queryAll();
    }

    @GetMapping("/test")
    public UserEntity test() {
        UserEntity user = new UserEntity();
        user = userService.queryTest();
        return user;
    }
}
