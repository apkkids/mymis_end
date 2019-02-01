package com.apkkids;

import com.apkkids.bean.Admin;
import com.apkkids.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
* @Description AdminService的单元测试
* @Author alex
* @Date 2019/2/1 0001 下午 5:52
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    AdminService service;
    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        List<Admin> adminList = service.getAllAdmin();
        for (Admin admin : adminList) {
            System.out.println(admin);
        }

        if (!adminList.isEmpty()) {
            Long id = adminList.get(0).getId();
            Admin admin = service.getAdminById(id);
            System.out.println("the first admin is :");
            System.out.println(admin);
        }

    }
}
