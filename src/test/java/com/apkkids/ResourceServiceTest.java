package com.apkkids;

import com.apkkids.bean.Resource;
import com.apkkids.service.ResourceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
* @Description ResourceService unit test
* @Author alex
* @Date 2019/3/4 0004 下午 9:02
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceTest {
    @Autowired
    ResourceService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        List<Resource> resources = service.getAllResources();
        for (Resource r : resources) {
            System.out.println(r);
        }
        if (!resources.isEmpty()) {
            //add 2 resource
            Resource r = resources.get(0);
            r.setName("testResource");
            r.setUrl("/main/test");
            r.setIs_enabled(true);
            r.setIcon_string("icon_string_test");
            r.setGmt_created(new Date());
            Assert.assertEquals(service.addResource(r).longValue(), 1l);

            r.setName("testResource2");
            Assert.assertEquals(service.addResource(r).longValue(), 1l);

            //update a resource
            resources = service.getAllResources();
            r = resources.get(resources.size() - 1); // the newest resource
            r.setName("updateResource");
            r.setUrl("/main/test/new");
            r.setIs_enabled(true);
            r.setIcon_string("icon_string_test_new");
            r.setGmt_modified(new Date());
            Assert.assertEquals(service.updateResource(r).longValue(),1l);

            //delete 2 resources
            String[] ids = new String[2];
            ids[0] = resources.get(resources.size() - 1).getId().toString();
            ids[1] = resources.get(resources.size() - 2).getId().toString();
            System.out.println(ids);
            Assert.assertEquals(service.deleteResources(ids).longValue(),2l);
        }
    }
}
