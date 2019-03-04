package com.apkkids.bean;/**
 * Created by wxb on 2019/1/31 0031.
 */

import java.util.Date;

/**
 * @Description 资源，代表系统中对资源的访问权限，对应resource_sys表
 * @Author alex
 * @Date 2019/1/31 0031 下午 10:16
 */
public class Resource {
    private Long id;
    private String name;
    private String url;
    private boolean is_enabled;
    private String icon_string;
    private Date gmt_created;
    private Date gmt_modified;

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", is_enabled=" + is_enabled +
                ", ico_string='" + icon_string + '\'' +
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean is_enabled) {
        this.is_enabled = is_enabled;
    }

    public String getIcon_string() {
        return icon_string;
    }

    public void setIcon_string(String icon_string) {
        this.icon_string = icon_string;
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
