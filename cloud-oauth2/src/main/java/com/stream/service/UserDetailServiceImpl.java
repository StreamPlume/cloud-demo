package com.stream.service;

import com.stream.feign.UserFeign;
import com.stream.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stream on 2018/10/21.
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserFeign userFeignClient;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userFeignClient.queryName(username);
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER");

        UserDetails userDetails = new User(user.getName(),
                passwordEncoder.encode("123456"),
                grantedAuthorities);
        return userDetails;
    }
}
