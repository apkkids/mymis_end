package com.apkkids;

import com.apkkids.bean.Nation;
import com.apkkids.service.DictionaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
* @Description DictionaryService的单元测试
* @Author alex
* @Date 2019/2/1 0001 下午 6:26
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryServiceTest {
    @Autowired
    DictionaryService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        List<Nation> nationList = service.getAllNation();
        for (Nation nation : nationList) {
            System.out.println(nation);
        }
        if (!nationList.isEmpty()) {
            Nation nation = nationList.get(0);
            nation.setName("test");
            nation.setGmt_modified(new Date());
            Long rel = service.addNation(nation);
            System.out.println("add nation, rel = "+rel);
        }
    }

}
