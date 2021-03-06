package com.apkkids.mapper;

import com.apkkids.bean.Nation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @Description Nation的Mapper接口
* @Author alex
* @Date 2019/2/1 0001 下午 6:20
*/
@Mapper
@Component
public interface NationMapper {
    List<Nation> getAllNation();

    Long addNation(@Param("nation") Nation nation);

    Long deleteNations(@Param("ids") String[] ids);

    Long updateNation(@Param("nation") Nation nation);
}
