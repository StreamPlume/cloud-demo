package com.stream.controller;

import com.stream.model.entity.UserEntity;
import com.stream.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Stream on 2018/7/4.
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserService userService;

    @PostMapping("/info/{id}")
    public UserEntity queryUser(@PathVariable Long id){
        UserEntity user;
        user = userService.getUser(id);
        try {
//            int time = (int) (Math.random() *150) ;
//            Thread.sleep(time);
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return user;
    }

    @PostMapping("/queryUserServer")
    public UserEntity queryUserServer(){
        UserEntity user;
        Long i = Double.valueOf(Math.random() *1000).longValue() ;
        user = userService.getUser(i);
        return user;
    }

    @GetMapping("/queryAll")
    public List<UserEntity> queryAll() {
        return userService.queryAll();
    }

    @GetMapping("/test")
    public UserEntity queryTest(HttpServletRequest request){
        Enumeration<String> parameterNames = request.getParameterNames();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            log.info("queryTest -->" + name + " : " + request.getHeader(name));
        }

        UserEntity user = new UserEntity();
        user.setId(0L);
        user.setName("user-server test");
        user.setSex("man");
        return user;
    }
}
