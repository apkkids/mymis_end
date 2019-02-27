package com.apkkids.service;

import com.apkkids.bean.JobLevel;
import com.apkkids.bean.Nation;
import com.apkkids.bean.PoliticalStatus;
import com.apkkids.bean.Position;
import com.apkkids.mapper.JobLevelMapper;
import com.apkkids.mapper.NationMapper;
import com.apkkids.mapper.PoliticalStatusMapper;
import com.apkkids.mapper.PositionMapper;
import jdk.nashorn.internal.scripts.JO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Policy;
import java.util.Date;
import java.util.List;

/**
 * @Description 提供所有字典表的CURD服务，包括nation_dic，joblevel_dic，politicalstatus_dic，position_idc
 * @Author alex
 * @Date 2019/2/1 0001 下午 6:25
 */
@Service
@Transactional
public class DictionaryService {
    @Autowired
    NationMapper nationMapper;
    @Autowired
    JobLevelMapper jobLevelMapper;
    @Autowired
    PositionMapper positionMapper;
    @Autowired
    PoliticalStatusMapper politicalStatusMapper;

    //Nation dictionary service
    public List<Nation> getAllNation() {
        return nationMapper.getAllNation();
    }

    public Long addNation(Nation nation) {
        //增加记录时永远要设置gmt_created
        nation.setGmt_created(new Date());
        return nationMapper.addNation(nation);
    }

    public Long deleteNations(String[] ids) {
        return nationMapper.deleteNations(ids);
    }

    public Long updateNation(Nation nation) {
        nation.setGmt_modified(new Date());
        return nationMapper.updateNation(nation);
    }

    //JobLevel dictionary service
    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }

    public Long addJobLevel(JobLevel jobLevel) {
        //增加记录时永远要设置gmt_created
        jobLevel.setGmt_created(new Date());
        return jobLevelMapper.addJobLevel(jobLevel);
    }

    public Long deleteJobLevels(String[] ids) {
        return jobLevelMapper.deleteJobLevels(ids);
    }

    public Long updateJobLevel(JobLevel jobLevel) {
        jobLevel.setGmt_modified(new Date());
        return jobLevelMapper.updateJobLevel(jobLevel);
    }

    //Position dictionary service
    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    public Long addPosition(Position position) {
        position.setGmt_created(new Date());
        return positionMapper.addPosition(position);
    }

    public Long deletePositions(String[] ids) {
        return positionMapper.deletePositions(ids);
    }

    public Long updatePosition(Position position) {
        position.setGmt_modified(new Date());
        return positionMapper.updatePosition(position);
    }

    //politicalStatus dictionary service
    public List<PoliticalStatus> getAllPolicicalStatus() {
        return politicalStatusMapper.getAllPolicicalStatus();
    }

    public Long addPoliticalStatus(PoliticalStatus politicalStatus) {
        politicalStatus.setGmt_created(new Date());
        return politicalStatusMapper.addPoliticalStatus(politicalStatus);
    }

    public Long deletePoliticalStatus(@Param("ids") String[] ids) {
        return politicalStatusMapper.deletePoliticalStatus(ids);
    }

    public Long updatePoliticalStatus(PoliticalStatus politicalStatus) {
        politicalStatus.setGmt_modified(new Date());
        return politicalStatusMapper.updatePoliticalStatus(politicalStatus);
    }

}
