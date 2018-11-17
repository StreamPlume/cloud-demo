package com.stream.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableOAuth2Sso
public class LoginConfigurer extends WebSecurityConfigurerAdapter {

    // 配置拦截规则
// https://blog.csdn.net/adsadadaddadasda/article/details/81476653
// https://github.com/spring-cloud-samples/sso/blob/master/src/main/java/demo/SsoApplication.java
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**").authorizeRequests()
// 原本想授权服务器通过网关访问（网关做负载均衡），鉴权由授权服务器自己控制，但发现通过网关访问对授权请求（/oauth/authorize 和/oauth/token）的路径无做用，只对资源服务器的配置起做用。看来需要自定义鉴权配置
//                .antMatchers("/oauth2-server/**").permitAll() // 对授权服务器请求路径不需要授权
                .anyRequest()
                .authenticated()
//              .and().csrf()
//                .csrfTokenRepository(csrfTokenRepository()).and()
//                .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
                .and()
                .logout().logoutUrl("/oauth2-server/user/logout").permitAll()
                .logoutSuccessUrl("/");
    }
}
