package com.apkkids.service;

import com.apkkids.bean.Role;
import com.apkkids.mapper.RoleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
* @Description 实现Role的数据库操作服务
* @Author alex
* @Date 2019/3/3 0003 下午 12:50
*/
@Service
@Transactional
public class RoleService {
    @Autowired
    RoleMapper mapper;
    public List<Role> getAllRoles(){
        return mapper.getAllRoles();
    }

    public  List<Role> getRolesByAdminId( Long id){
        return mapper.getRolesByAdminId(id);
    }

    public Role getRoleById(Long id){
        return mapper.getRoleById(id);
    }

    public Long addRole(Role role){
        role.setGmt_created(new Date());
        return mapper.addRole(role);
    }

    public Long deleteRoles(String[] ids){
        return mapper.deleteRoles(ids);
    }

    public Long updateRole(Role role){
        role.setGmt_modified(new Date());
        return mapper.updateRole(role);
    }
}
