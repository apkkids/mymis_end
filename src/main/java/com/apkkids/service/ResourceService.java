package com.apkkids.service;

import com.apkkids.bean.Resource;
import com.apkkids.mapper.ResourceMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
* @Description Resource服务类，提供数据库操作
* @Author alex
* @Date 2019/3/4 0004 下午 8:59
*/
@Service
@Transactional
public class ResourceService {
    @Autowired
    ResourceMapper mapper;
    public List<Resource> getAllResources(){
        return mapper.getAllResources();
    }

    public Resource getResourceById(Long id){
        return mapper.getResourceById(id);
    }

    public Long addResource(Resource resource){
        resource.setGmt_created(new Date());
        return mapper.addResource(resource);
    }

    public Long deleteResources(String[] ids){
        return mapper.deleteResources(ids);
    }

    public Long updateResource(Resource resource){
        resource.setGmt_modified(new Date());
        return mapper.updateResource(resource);
    }
}
