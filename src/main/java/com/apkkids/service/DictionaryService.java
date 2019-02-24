package com.apkkids.service;

import com.apkkids.bean.Nation;
import com.apkkids.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
* @Description 提供所有字典表的CURD服务，包括nation_dic，joblevel_dic，politicalstatus_dic，position_idc
* @Author alex
* @Date 2019/2/1 0001 下午 6:25
*/
@Service
@Transactional
public class DictionaryService {
    @Autowired
    NationMapper nationMapper;
    public List<Nation> getAllNation() {
        return nationMapper.getAllNation();
    }

    public Long addNation(Nation nation) {
        //增加记录时永远要设置gmt_created
        nation.setGmt_created(new Date());
        return nationMapper.addNation(nation);
    }

    public Long deleteNations(String[] ids){
        return nationMapper.deleteNations(ids);
    }

    public Long updateNation(Nation nation) {
        return nationMapper.updateNation(nation);
    }
}