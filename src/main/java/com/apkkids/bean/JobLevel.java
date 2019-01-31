package com.apkkids.bean;
import java.util.Date;

/**
 * @Description 员工的职级，对应字典表joblevel_dic
 * @Author alex
 * @Date 2019/1/31 0031 下午 10:28
 */
public class JobLevel {
    private Long id;
    private String name;
    private String titleLevel;
    private boolean is_enabled;
    private Date gmt_created;
    private Date gmt_modified;

    @Override
    public String toString() {
        return "JobLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", titleLevel='" + titleLevel + '\'' +
                ", is_enabled=" + is_enabled +
                ", gmt_created=" + gmt_created +
                ", gmt_modified=" + gmt_modified +
                '}';
    }

    /**
     * name和titleLevel这两个属性一致，则认为两个对象一致
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobLevel jobLevel = (JobLevel) o;

        if (!name.equals(jobLevel.name)) return false;
        return titleLevel.equals(jobLevel.titleLevel);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + titleLevel.hashCode();
        return result;
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

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public boolean isIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean is_enabled) {
        this.is_enabled = is_enabled;
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
