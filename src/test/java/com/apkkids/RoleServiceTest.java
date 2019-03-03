package com.apkkids;

import com.apkkids.bean.Role;
import com.apkkids.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
* @Description RoleService的单元测试
* @Author alex
* @Date 2019/3/3 0003 下午 5:15
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {
    @Autowired
    RoleService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        List<Role> roles = service.getAllRoles();
        for (Role role : roles) {
            System.out.println(role);
        }
        if (!roles.isEmpty()) {
            //增加两个角色
            Role role = roles.get(0);
            role.setName("ROLE_TEST1");
            role.setName_ch("测试人员1");
            Assert.assertEquals(service.addRole(role).longValue(),1l);

            role.setName("ROLE_TEST2");
            role.setName_ch("测试人员2");
            Assert.assertEquals(service.addRole(role).longValue(),1l);

            //在数据库中查找角色
            Role roleInDb = service.getRoleById(role.getId());
            Assert.assertNotNull(roleInDb);
            Assert.assertEquals(roleInDb.getId(),role.getId());

            //查找最后一个角色，也就是刚刚插入的角色，进行修改
            roles = service.getAllRoles();
            role = roles.get(roles.size() - 1);
            role.setName("ROLE_UPDATE");
            role.setName_ch("修改的角色");
            role.setGmt_modified(new Date());
            Assert.assertEquals(service.updateRole(role).longValue(),1l);

            //删除插入的两个角色
            String[] ids = new String[2];
            ids[0] = roles.get(roles.size()-1).getId().toString();
            ids[1] = roles.get(roles.size()-2).getId().toString();
            Assert.assertEquals(service.deleteRoles(ids).longValue(),2l);
        }
    }
}
