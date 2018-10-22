package com.stream.service;

import com.stream.feign.UserFeign;
import com.stream.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stream on 2018/7/6.
 */
@Service
public class UserService {

    @Autowired
    private UserFeign userFeignClient;

//    @HystrixCommand(fallbackMethod = "queryUserFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
//    })
    public UserEntity queryUser(Long id){
        return userFeignClient.queryId(id);
    }

    public UserEntity queryUserFallback(Long id) {
        UserEntity user = new UserEntity();
        user.setName("queryUserFallback");
        return user;
    }

    public UserEntity queryName(String userName){
        return userFeignClient.queryName(userName);
    }

    public List<UserEntity> queryAll(){
        List<UserEntity> list = userFeignClient.queryAll();
        for (UserEntity user : list) {
            System.out.println(user.getId());
        }
        return list;
    }

    public UserEntity queryTest(){
        return userFeignClient.test();
    }

}
