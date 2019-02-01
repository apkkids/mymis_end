package com.apkkids.bean;

import java.util.Date;

/**
* @Description 账套，对应数据表salary
* @Author alex
* @Date 2019/2/1 0001 下午 5:10
*/
public class Salary {
    private Long id;
    private String name;
    private Integer basic;
    private Integer bonus;
    private Integer lunchAllowance;
    private Integer trafficAllowance;
    private Integer allSalary;
    private Integer pensionBase;
    private Float pensionPer;
    private Integer medicalBase;
    private Float medicalPer;
    private Integer housingFundBase;
    private Float housingFundPer;
    private Date gmt_created;
    private Date gmt_modified;

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basic=" + basic +
                ", bonus=" + bonus +
                ", lunchAllowance=" + lunchAllowance +
                ", trafficAllowance=" + trafficAllowance +
                ", allSalary=" + allSalary +
                ", pensionBase=" + pensionBase +
                ", pensionPer=" + pensionPer +
                ", medicalBase=" + medicalBase +
                ", medicalPer=" + medicalPer +
                ", housingFundBase=" + housingFundBase +
                ", housingFundPer=" + housingFundPer +
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

    public Integer getBasic() {
        return basic;
    }

    public void setBasic(Integer basic) {
        this.basic = basic;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getLunchAllowance() {
        return lunchAllowance;
    }

    public void setLunchAllowance(Integer lunchAllowance) {
        this.lunchAllowance = lunchAllowance;
    }

    public Integer getTrafficAllowance() {
        return trafficAllowance;
    }

    public void setTrafficAllowance(Integer trafficAllowance) {
        this.trafficAllowance = trafficAllowance;
    }

    public Integer getAllSalary() {
        return allSalary;
    }

    public void setAllSalary(Integer allSalary) {
        this.allSalary = allSalary;
    }

    public Integer getPensionBase() {
        return pensionBase;
    }

    public void setPensionBase(Integer pensionBase) {
        this.pensionBase = pensionBase;
    }

    public Float getPensionPer() {
        return pensionPer;
    }

    public void setPensionPer(Float pensionPer) {
        this.pensionPer = pensionPer;
    }

    public Integer getMedicalBase() {
        return medicalBase;
    }

    public void setMedicalBase(Integer medicalBase) {
        this.medicalBase = medicalBase;
    }

    public Float getMedicalPer() {
        return medicalPer;
    }

    public void setMedicalPer(Float medicalPer) {
        this.medicalPer = medicalPer;
    }

    public Integer getHousingFundBase() {
        return housingFundBase;
    }

    public void setHousingFundBase(Integer housingFundBase) {
        this.housingFundBase = housingFundBase;
    }

    public Float getHousingFundPer() {
        return housingFundPer;
    }

    public void setHousingFundPer(Float housingFundPer) {
        this.housingFundPer = housingFundPer;
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
