package com.stream.feign.fallback;

import com.stream.feign.UserFeign;
import com.stream.model.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by Stream on 2018/7/5.
 */

@Slf4j
@Component
public class UserFeignFallbackImpl implements UserFeign {

    public UserEntity queryUser(Long id) {
//        log.error("调用{}异常{}","queryUser",id);
        UserEntity user = new UserEntity();
        user.setName("UserFeignFallbackImpl- queryUser");
        return user;
    }

    @Override
    public UserEntity queryUserServer() {
        UserEntity user = new UserEntity();
        user.setName("UserFeignFallbackImpl queryUserServer");
        return user;
    }

    @Override
    public List<UserEntity> queryAll() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public UserEntity queryTest() {
        UserEntity user = new UserEntity();
        user.setName("UserFeignFallbackImpl- queryTest");
        return user;
    }
}
