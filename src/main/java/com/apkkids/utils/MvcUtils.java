package com.apkkids.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

/**
* @Description 提供关于MVC，Spring Security的一些方法
* @Author alex
* @Date 2019/3/7 0007 下午 8:39
*/
public class MvcUtils {
    /**
     * 从SecurityContextHolder中得到Authentication对象，进而获取权限列表，这个方法多用于测试
     * @param url url地址
     * @return 一个由用户名、角色列表和地址组成的字符串
     */
    public static String getUserAndRolesFromSecurity(String url){
        //从SecurityContextHolder中得到Authentication对象
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String rel = "url地址:"+url+"\t";

        if (auth != null) {
            rel += "\t用户名:";
            rel += auth.getName();

            Collection<GrantedAuthority> authorityCollection = (Collection<GrantedAuthority>) auth.getAuthorities();
            rel += "\t权限:";
            for (GrantedAuthority a : authorityCollection) {
                rel += "\t" + a.getAuthority();
            }
        }
        return rel;
    }
}
