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

    public UserEntity queryId(Long id) {
        UserEntity user = new UserEntity();
        user.setName("UserFeignFallbackImpl- queryId");
        return user;
    }

    @Override
    public UserEntity queryName(String userName) {
        UserEntity user = new UserEntity();
        user.setName("UserFeignFallbackImpl queryName");
        return user;
    }

    @Override
    public List<UserEntity> queryAll() {
        return Collections.EMPTY_LIST;
    }
}
