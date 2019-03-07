package com.apkkids.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * Author:      wxb
 * Project:     mymis_end
 * Create Date: 2019/3/7
 * Create Time: 16:44
 * Description: 访问决策管理员的实现类，实现鉴权过程中的决策。
 * 本系统中，若要访问的网址所需的角色，是当前登录用户拥有的角色，则可以访问；否则不能访问。
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    /**
     * 该方法实现了访问决策
     * @param authentication 登录凭据，包含用户名等
     * @param o              要访问的资源
     * @param collection     所需要的角色列表，来自MySecurityMetadataSource的getAttributes方法
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new BadCredentialsException("用户未登录");
        }

        //1.得到当前用户的角色，这里就是得到了Admin的roles
        Collection<? extends GrantedAuthority> userAuthorities = authentication.getAuthorities();

        //2.遍历collection
        Iterator<ConfigAttribute> iterator = collection.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute attribute = iterator.next();
            String roleName = attribute.getAttribute();

            //3.如果该资源不需要任何角色，直接返回
            if ("ROLE_NONE".equals(roleName)) {
                return;
            }

            //4.一一比对角色
            for (GrantedAuthority authority : userAuthorities) {
                //拥有admin角色，什么都可以访问
                if (authority.getAuthority().equals("ROLE_admin")) {
                    return;
                }
                //角色匹配，可以访问资源
                if (authority.getAuthority().equals(roleName)) {
                    return;
                }
            }

        }
        //如果不能匹配
        throw new AccessDeniedException("你没有访问" + o + "的权限!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
