package com.apkkids.utils;

import com.apkkids.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
* @Description 为了能够在普通类中使用Mapper接口提供的工具类
* @Author alex
* @Date 2019/3/5 0005 下午 9:08
*/
@Component
public class DaoUtils {
    @Autowired
    RoleMapper roleMapper;
    public static DaoUtils daoUtils;

    @PostConstruct
    public void init(){
        daoUtils = this;
    }

    public static DaoUtils getInstance(){
        if (daoUtils == null) {
            daoUtils = new DaoUtils();
        }
        return daoUtils;
    }

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }
}
