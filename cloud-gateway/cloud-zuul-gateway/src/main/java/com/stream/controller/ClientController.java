package com.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private RestOperations restOperations;

    @RequestMapping("/me")
    public String personStr() {

        // 测试访问资源服务器
        String personResourceUrl = "http://localhost:8900/user/me";
        String forObject = restOperations.getForObject(personResourceUrl, String.class);

        return forObject;
    }

    @RequestMapping(value = "/client",method = RequestMethod.GET)
    public String client() {
        return "cleint, Hollo world";
    }
}
