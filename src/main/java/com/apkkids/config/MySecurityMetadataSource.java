package com.apkkids.config;

import com.apkkids.bean.Resource;
import com.apkkids.bean.Role;
import com.apkkids.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
* @Description 安全元数据源类，这个类用于鉴权过程中提供权限，它接收要访问的资源，从数据库中查询
 * 访问该资源需要的角色，构造一个集合返回所有可用角色
* @Author alex
* @Date 2019/3/6 0006 下午 9:36
*/
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    ResourceService resourceService;
    //路径匹配器
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 此方法返回访问资源需要的角色集合，用于鉴权
     * @param o 要访问的资源
     * @return Collection<ConfigAttribute>集合
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //从object中得到要访问的资源，即网址
        String requestUrl = ((FilterInvocation)o ).getRequestUrl();
        System.out.println(requestUrl);

        //得到数据库中的所有资源（即网址）
        List<Resource> allResource = resourceService.getAllResources();
        for (Resource resource : allResource) {
            //依次检测资源url是否匹配请求的url
            if (antPathMatcher.match(resource.getUrl(), requestUrl) && !resource.getRoles().isEmpty()) {
                //如果匹配成功，则将所有角色纳入SecurityConfig
                List<Role> roles = resource.getRoles();
                String[] values = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //如果匹配不成功，返回一个ROLE_NONE
        return SecurityConfig.createList("ROLE_NONE");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
