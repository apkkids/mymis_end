package com.apkkids.bean;

import java.util.Date;

/**
* @Description 组织，代表一个单位内部的多级组织架构，对应数据库表organization
* @Author alex
* @Date 2019/1/31 0031 下午 10:43
*/
public class Organization {
    private Long id;
    private String name;
    private Long parent_id;
    private boolean is_parent;
    private Date gmt_created;
    private Date gmt_modified;

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent_id=" + parent_id +
                ", is_parent=" + is_parent +
                ", gmt_created=" + gmt_created +
                ", gmt_modified=" + gmt_modified +
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

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public boolean isIs_parent() {
        return is_parent;
    }

    public void setIs_parent(boolean is_parent) {
        this.is_parent = is_parent;
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
}
