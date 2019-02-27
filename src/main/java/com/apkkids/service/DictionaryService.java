package com.apkkids.service;

import com.apkkids.bean.JobLevel;
import com.apkkids.bean.Nation;
import com.apkkids.bean.Position;
import com.apkkids.mapper.JobLevelMapper;
import com.apkkids.mapper.NationMapper;
import com.apkkids.mapper.PositionMapper;
import jdk.nashorn.internal.scripts.JO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return jobLevelMapper.updateJobLevel(jobLevel);
    }

    //Position dictionary service
    List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    Long addPosition(Position position) {
        position.setGmt_created(new Date());
        return positionMapper.addPosition(position);
    }

    Long deletePositions(String[] ids) {
        return positionMapper.deletePositions(ids);
    }

    Long updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }
}
