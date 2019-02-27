package com.apkkids.mapper;

import com.apkkids.bean.JobLevel;
import com.apkkids.bean.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description Position的MapperJ接口
* @Author alex
* @Date 2019/2/27 0027 下午 12:52
*/
@Mapper
public interface PositionMapper {
    List<Position> getAllPositions();

    Long addPosition(@Param("position") Position position);

    Long deletePositions(@Param("ids") String[] ids);

    Long updatePosition(@Param("position") Position position);
}
