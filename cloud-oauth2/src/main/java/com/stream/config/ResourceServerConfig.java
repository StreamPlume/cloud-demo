package com.stream.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by Stream on 2018/9/9.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.resourceId("users-info");
//    }


    // 配置需要资源服务器通过 ?access_token=47bc9b8c-40d6-4233-b414-c6b5f640d848 鉴权的资源 url
    // 资源服务器没配置的url，由授权服务器控制
    @Override
    public void configure(HttpSecurity http) throws Exception { // @formatter:off
        http.requestMatchers()
                //匹配到 antMatchers 中ant正则表达式的 url 使用这个 HttpSecurity 规则鉴权
                .antMatchers("/user/**")
            .and()
                .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .permitAll();
    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//
//        http.httpBasic()
//                .and()
//                    .csrf().disable()
//                    .requestMatchers()
//                    .antMatchers("/users/**")
//                .and()
//                    .authorizeRequests()
////                    .antMatchers("/oauth/authorize").fullyAuthenticated()
//                    .antMatchers("/login").permitAll()
//                    .antMatchers("/users/**").authenticated()
//                    .anyRequest().authenticated()
////                .and()
////                    .requestMatchers()
////                    .antMatchers("/oauth/authorize",/*tokenKeyPath, checkTokenPath,*/ "/users/**")
//                .and()
//                    .formLogin()
//                .and()
//                    .logout().permitAll()
//                .and()
//                    .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        ;
//    }


    /**
    @Override
    public void configure1(HttpSecurity http) throws Exception {

        http.csrf().disable()//禁用了 csrf 功能
                .authorizeRequests()//限定签名成功的请求
                .antMatchers("/decision/**","/govern/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/test/**").authenticated()//必须认证过后才可以访问
                .anyRequest().permitAll()//其他没有限定的请求，允许随意访问
                .and().anonymous()//对于没有配置权限的其他请求允许匿名访问
                .and().formLogin()//使用 spring security 默认登录页面
                .and().httpBasic();//启用http 基础验证

    }
  */

}