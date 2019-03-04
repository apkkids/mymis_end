package com.apkkids.mapper;

import com.apkkids.bean.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @Description Resource的Mapper接口
* @Author alex
* @Date 2019/3/4 0004 下午 8:52
*/
@Mapper
@Component
public interface ResourceMapper {
    List<Resource> getAllResources();

    Resource getResourceById(@Param("id") Long id);

    Long addResource(@Param("resource") Resource resource);

    Long deleteResources(@Param("ids") String[] ids);

    Long updateResource(@Param("resource") Resource resource);
}
