package com.apkkids.mapper;

import com.apkkids.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @Description Role的Mapper接口
* @Author alex
* @Date 2019/3/3 0003 下午 12:12
*/
@Mapper
@Component
public interface RoleMapper {
    List<Role> getAllRoles();

    Role getRoleById(@Param("id") Long id);

    Long addRole(@Param("role") Role role);

    Long deleteRoles(@Param("ids") String[] ids);

    Long updateRole(@Param("role") Role role);
}
