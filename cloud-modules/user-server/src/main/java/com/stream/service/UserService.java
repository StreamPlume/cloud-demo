package com.stream.service;

import com.google.common.collect.Maps;
import com.stream.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Stream on 2018/7/4.
 */

@Service
@RefreshScope
public class UserService {

    @Value("${user.name:noGit}")
    private String profile;

    @Value("${common.config:noCommonConfig}")
    private String commonConfig;

    public UserEntity getUser(Long id){
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName("user-server Stream");
        char[] password = {'1','2','3'};
        user.setPassword(password);
        return user;
    }


    public List<UserEntity> queryAll(){
        List<UserEntity> list = new ArrayList<>();
        UserEntity u1 = new UserEntity();
        u1.setId(1L);
        u1.setName("user-server Stream");
        list.add(u1);

        UserEntity u2 = new UserEntity();
        u2.setId(2L);
        u2.setName("user-server Plume");
        list.add(u2);

        UserEntity u3 = new UserEntity();
        u3.setId(3L);
        u3.setName("user-server root");
        list.add(u3);

        return list;
    }

    public Map<String,String> getConfig() {
        Map<String,String> map = Maps.newHashMap();
        map.put("proFile", profile);
        map.put("commonConfig", commonConfig);
        return map;
    }
}
