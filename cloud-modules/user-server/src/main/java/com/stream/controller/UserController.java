package com.stream.controller;

import com.stream.model.entity.UserEntity;
import com.stream.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Stream on 2018/7/4.
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserService userService;

    @GetMapping("/{id}")
    public UserEntity queryId(@PathVariable Long id){
        UserEntity user;
        user = userService.getUser(id);
        return user;
    }

    @PostMapping("/name")
    public UserEntity queryName(@RequestParam String userName){
        UserEntity user;
        user = userService.getUser(userName);
        return user;
    }

    @GetMapping("/list")
    public List<UserEntity> list() {
        return userService.queryAll();
    }

    @GetMapping("/test")
    public String test(){
        return "hollo world!";
    }

    @GetMapping("/queryGit")
    public Map<String,String> queryGit() {
        return userService.getConfig();
    }
}
