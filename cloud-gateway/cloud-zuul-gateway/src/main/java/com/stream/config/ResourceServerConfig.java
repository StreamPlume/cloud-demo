package com.stream.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by Stream on 2018/10/22.
 */

//@Configuration
//@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Autowired
//    private OAuth2ClientProperties oAuth2ClientProperties;

//    @Autowired
//    private AuthorizationServerProperties authorizationServerProperties;
//
//    @Bean
//    public AuthorizationServerProperties authorizationServerProperties() {
//        return new AuthorizationServerProperties();
//    }


//    @Bean
//    @Qualifier("authorizationHeaderRequestMatcher")
//    public RequestMatcher authorizationHeaderRequestMatcher() {
//        return new RequestHeaderRequestMatcher("Authorization");
//    }

    public void configure1(HttpSecurity http) throws Exception {

//        http.csrf().disable()//禁用了 csrf 功能
//                .authorizeRequests()//限定签名成功的请求
//                .anyRequest().authenticated()
//                .antMatchers("/decision/**","/govern/**").hasAnyRole("USER","ADMIN")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/**").authenticated()//必须认证过后才可以访问
//                .anyRequest().permitAll()//其他没有限定的请求，允许随意访问
//                .and().anonymous()//对于没有配置权限的其他请求允许匿名访问
//                .and().formLogin()//使用 spring security 默认登录页面
//                .and().httpBasic();//启用http 基础验证

        http.httpBasic()
                .and()
                .csrf().disable()
                .requestMatchers()
//                .antMatchers("/users/**")
                .and()
                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/users/**").authenticated()
                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ;
    }

//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.tokenServices(tokenServices());
//
//    }

//    @Bean
//    public ResourceServerTokenServices tokenServices() {
//        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//        remoteTokenServices.setCheckTokenEndpointUrl(authorizationServerProperties.getCheckTokenAccess());
//        remoteTokenServices.setClientId(oAuth2ClientProperties.getClientId());
//        remoteTokenServices.setClientSecret(oAuth2ClientProperties.getClientSecret());
//        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
//        return remoteTokenServices;
//    }
}
