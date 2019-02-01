package com.apkkids.mapper;

import com.apkkids.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description Admin的Mapper接口
* @Author alex
* @Date 2019/2/1 0001 下午 5:24
*/
@Mapper
public interface AdminMapper {
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
