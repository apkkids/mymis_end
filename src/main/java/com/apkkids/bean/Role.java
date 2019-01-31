package com.apkkids.bean;

import java.util.Date;
import java.util.List;

/**
 * @Description 角色，是资源的集合，对应role_sys表
 * @Author alex
 * @Date 2019/1/31 0031 下午 8:54
 */
public class Role {
    private Long id;
    private String name;
    private String name_ch;
    private Date gmt_created;
    private Date gmt_modified;
    private List<Resource> resourceList;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", name_ch='" + name_ch + '\'' +
                ", gmt_created=" + gmt_created +
                ", gmt_modified=" + gmt_modified +
                ", resourceList=" + resourceList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_ch() {
        return name_ch;
    }

    public void setName_ch(String name_ch) {
        this.name_ch = name_ch;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
