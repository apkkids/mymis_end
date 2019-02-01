package com.apkkids.service;

import com.apkkids.bean.Admin;
import com.apkkids.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description TODO
* @Author alex
* @Date 2019/2/1 0001 下午 5:44
*/
@Service
@Transactional
public class AdminService {
    @Autowired
    AdminMapper mapper;

    public List<Admin> getAllAdmin() {
        return mapper.getAllAdmin();
    }

    public Admin getAdminById(Long id) {
        return mapper.getAdminById(id);
    }
}
