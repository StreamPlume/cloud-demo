package com.stream.feign;

/**
 * Created by Stream on 2018/7/5.
 */

import com.stream.feign.fallback.UserFeignFallbackImpl;
import com.stream.model.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-server",fallback = UserFeignFallbackImpl.class)
public interface UserFeign {


    @GetMapping("/user/{id}")
    UserEntity queryId(@PathVariable("id") Long id);

    @PostMapping("/name")
    UserEntity queryName(@RequestParam("userName") String userName);

    @GetMapping("/user/list")
    List<UserEntity> queryAll();
}
