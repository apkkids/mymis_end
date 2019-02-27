package com.apkkids.mapper;

import com.apkkids.bean.PoliticalStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author:      wxb
 * Project:     mymis_end
 * Create Date: 2019/2/27
 * Create Time: 17:02
 * Description: politicalStatus Mapper interface
 */
@Mapper
@Component
public interface PoliticalStatusMapper {
    List<PoliticalStatus> getAllPolicicalStatus();

    Long addPoliticalStatus(@Param("politicalStatus") PoliticalStatus politicalStatus);

    Long deletePoliticalStatus(@Param("ids") String[] ids);

    Long updatePoliticalStatus(@Param("politicalStatus") PoliticalStatus politicalStatus);
}
