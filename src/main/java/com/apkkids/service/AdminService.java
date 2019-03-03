package com.apkkids.service;

import com.apkkids.bean.Admin;
import com.apkkids.bean.Role;
import com.apkkids.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description 提供Admin的数据库操作，同时实现了UserDetailsService接口，使它成为了
 * Spring Security中验证登录的一部分
* @Author alex
* @Date 2019/2/1 0001 下午 5:44
*/
@Service
@Transactional
public class AdminService  implements UserDetailsService{
    @Autowired
    AdminMapper mapper;

    public List<Admin> getAllAdmin() {
        return mapper.getAllAdmin();
    }

    public Admin getAdminById(Long id) {
        return mapper.getAdminById(id);
    }

    /**
     * 实现了UserDetailsService的接口，通过用户名在数据库中查询用户
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = mapper.getAdminByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("not found " + username + " in database");
        }
        return admin;
    }
}
