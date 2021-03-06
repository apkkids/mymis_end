package com.apkkids.bean;

import java.util.Date;

/**
* @Description 政治身份，对应字典表politicalstatus_dic
* @Author alex
* @Date 2019/1/31 0031 下午 10:41
*/
public class PoliticalStatus {
    private Long id;
    private String name;
    private Date gmt_created;
    private Date gmt_modified;

    @Override
    public String toString() {
        return "PoliticalStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gmt_created=" + gmt_created +
                ", gmt_modified=" + gmt_modified +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PoliticalStatus that = (PoliticalStatus) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
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
