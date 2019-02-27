package com.apkkids.mapper;

import com.apkkids.bean.JobLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author:      alex
 * Project:     mymis_end
 * Create Date: 2019/2/24
 * Create Time: 21:38
 * Description:
 */
@Mapper
@Component
public interface JobLevelMapper {
    List<JobLevel> getAllJobLevels();

    Long addJobLevel(@Param("jobLevel") JobLevel jobLevel);

    Long deleteJobLevels(@Param("ids") String[] ids);

    Long updateJobLevel(@Param("jobLevel") JobLevel jobLevel);
}
