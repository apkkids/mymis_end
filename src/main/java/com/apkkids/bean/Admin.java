package com.apkkids.bean;

import java.util.Date;
import java.util.List;

/**
 * @Description 管理员，拥有多个角色，对应admin_sys表
 * @Author alex
 * @Date 2019/1/31 0031 下午 8:54
 */
public class Admin {
    private Long id;
    private String username;
    private String password;
    private String name_ch;
    private String telephone;
    private String address;
    private boolean is_enabled;
    private Date gmt_created;
    private Date gmt_modified;
    private List<Role> roleList;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name_ch='" + name_ch + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", is_enabled=" + is_enabled +
                ", gmt_created=" + gmt_created +
                ", gmt_modified=" + gmt_modified +
                ", roleList=" + roleList +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName_ch() {
        return name_ch;
    }

    public void setName_ch(String name_ch) {
        this.name_ch = name_ch;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
