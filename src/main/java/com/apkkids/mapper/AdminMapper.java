package com.apkkids.mapper;

import com.apkkids.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @Description Admin的Mapper接口
* @Author alex
* @Date 2019/2/1 0001 下午 5:24
*/
@Mapper
@Component
public interface AdminMapper {

    /**
     * 通过username查询管理员
     * @param username
     * @return 找到的管理员
     */
    Admin getAdminByUsername(@Param("username") String username) ;


    /**
     * 得到系统中所有的管理员
     * @return
     */
    List<Admin> getAllAdmin();

    /**
     * 通过id查询管理员
     * @param id
     * @return
     */
    Admin getAdminById(@Param("id") Long id);

}
