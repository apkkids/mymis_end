package com.apkkids.controller;

import com.apkkids.utils.MvcUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:      wxb
 * Project:     mymis_end
 * Create Date: 2019/3/7
 * Create Time: 17:45
 * Description: 该Controller是为了测试登录鉴权功能而提供的，它包含一些用于测试的网址
 * 用户   角色
 * admin  ROLE_admin
 * test1  ROLE_manager
 * test2  ROLE_personnel
 *
 * 资源   所需角色
 * /test/admin ROLE_admin
 * /test/manager ROLE_manager
 * /test/personnel ROLE_personnel
 *
 * 测试过程
 * admin访问三个资源，均可
 * test1访问三个资源，只有第二个可以
 * test2访问三个资源，只有第三个可以
 */
@RestController
public class TestSecurityController {
    @RequestMapping(value = "/test/admin", method = RequestMethod.GET)
    public String test_admin() {
        return MvcUtils.getUserAndRolesFromSecurity("/test/admin");
    }

    @RequestMapping(value = "/test/manager", method = RequestMethod.GET)
    public String test_manager() {
        return MvcUtils.getUserAndRolesFromSecurity("/test/manager");
    }

    @RequestMapping(value = "/test/personnel", method = RequestMethod.GET)
    public String test_personnel() {
        return MvcUtils.getUserAndRolesFromSecurity("/test/personnel");
    }
}
