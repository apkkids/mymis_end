package com.apkkids;

import com.apkkids.bean.JobLevel;
import com.apkkids.bean.Nation;
import com.apkkids.service.DictionaryService;
import org.junit.Assert;
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
    public void testNationService() {
        List<Nation> nationList = service.getAllNation();
        int originSize = nationList.size();

        if (!nationList.isEmpty()) {
            //添加两条记录
            Nation nation = nationList.get(0);
            nation.setName("test1");
            nation.setGmt_modified(new Date());
            Long rel = service.addNation(nation);
            System.out.println("add nation, rel = " + rel);

            nation.setName("test2");
            nation.setGmt_modified(new Date());
            rel = service.addNation(nation);
            System.out.println("add nation, rel = " + rel);

            //修改最后一条记录
            nationList = service.getAllNation();
            nation = nationList.get(nationList.size() - 1);
            nation.setName("testLast");
            nation.setGmt_created(new Date());
            nation.setGmt_modified(new Date());
            System.out.println(nation);
            rel = service.updateNation(nation);
            nationList = service.getAllNation();
            Nation newNation = nationList.get(nationList.size() - 1);
            System.out.println(newNation);
            //查看是否修改成功
            Assert.assertEquals(nation, newNation);

            //删除最后两条记录
            String[] ids = new String[2];
            ids[0] = nationList.get(nationList.size() - 1).getId().toString();
            ids[1] = nationList.get(nationList.size() - 2).getId().toString();
            rel = service.deleteNations(ids);
            System.out.println("delete 2 nations, rel = " + rel);
        }
        int endSize = service.getAllNation().size();
        Assert.assertEquals(originSize,endSize);
    }

    @Test
    public void testJobLevelService() {
        List<JobLevel> jobLevelList = service.getAllJobLevels();
        int originSize = jobLevelList.size();

        if (!jobLevelList.isEmpty()) {
            //添加两条记录
            JobLevel jobLevel = jobLevelList.get(0);
            jobLevel.setName("test1");
            jobLevel.setGmt_modified(new Date());
            jobLevel.setTitleLevel("测试工程师1");
            Long rel = service.addJobLevel(jobLevel);
            System.out.println("add nation, rel = " + rel);

            jobLevel.setName("test2");
            jobLevel.setGmt_modified(new Date());
            jobLevel.setTitleLevel("测试工程师2");
            rel = service.addJobLevel(jobLevel);
            System.out.println("add nation, rel = " + rel);

            //修改最后一条记录
            jobLevelList = service.getAllJobLevels();
            jobLevel = jobLevelList.get(jobLevelList.size() - 1);
            jobLevel.setName("testLast");
            jobLevel.setGmt_created(new Date());
            jobLevel.setGmt_modified(new Date());
            jobLevel.setTitleLevel("检测工程师");
            jobLevel.setIs_enabled(true);
            System.out.println(jobLevel);
            rel = service.updateJobLevel(jobLevel);
            jobLevelList = service.getAllJobLevels();
            JobLevel newJobLevel  = jobLevelList.get(jobLevelList.size() - 1);
            System.out.println(newJobLevel);
            //查看是否修改成功
            Assert.assertEquals(jobLevel, newJobLevel);

            //删除最后两条记录
            String[] ids = new String[2];
            ids[0] = jobLevelList.get(jobLevelList.size() - 1).getId().toString();
            ids[1] = jobLevelList.get(jobLevelList.size() - 2).getId().toString();
            rel = service.deleteJobLevels(ids);
            System.out.println("delete 2 jobLevels, rel = " + rel);
        }
        int endSize = service.getAllJobLevels().size();
        Assert.assertEquals(originSize,endSize);
    }

}
