package com.apkkids.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by wxb on 2019/1/28 0028.
 * 用来测试的Controller类
 */
@RestController
public class SimpleController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("get the url /hello, print hello.");

        //从SecurityContextHolder中得到Authentication对象，进而获取权限列表，传到前端
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String rel = "url地址:/hello\n";

        if (auth != null) {
            rel += "\n用户名:";
            rel += auth.getName();

            Collection<GrantedAuthority> authorityCollection = (Collection<GrantedAuthority>) auth.getAuthorities();
            rel += "\n权限:";
            for (GrantedAuthority a : authorityCollection) {
                rel += "\n" + a.getAuthority();
            }
        }
        return rel;
    }
}
