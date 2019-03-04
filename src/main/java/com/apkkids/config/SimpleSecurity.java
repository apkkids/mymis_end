package com.apkkids.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by wxb on 2019/1/28 0028.
 * 用来测试的权限配置类，正式版本中将被废弃
 */
//注释掉@EnableWebSecurity使得该配置类无效
//@EnableWebSecurity
public class SimpleSecurity extends WebSecurityConfigurerAdapter {
    //插入一个后门验证类，使得程序在开始时可以通过权限验证
    @Autowired BackdoorAuthenticationProvider backdoorAuthenticationProvider;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //将自定义验证类注册进去
        auth.authenticationProvider(backdoorAuthenticationProvider);
    }
}
