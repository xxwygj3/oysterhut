package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class CustomerChild extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
 
    private Integer chlId;
    /** 用户编号 **/
    private String cusCode;
    /** 亲子编号 **/
    private String chlCode;
    /** 录入时间 **/
    private String chlTime;
    /** 录入日期 **/
    private String chlDate;
    /** 手机号码 **/
    private String cusMobile;
    /** 昵称 **/
    private String nickName;
    /** 等级 **/
    private Integer grade;
    /** 宝宝性别 **/
    private Integer chlSex;
    /** 宝宝年龄 **/
    private Integer chlAge;
    /** 宝宝星座 **/
    private String chlStar;
    /** 收件地址 **/
    private String address;
    /** 头像地址 **/
    private String imgUrl;
    /** 状态 **/
    private String status;
 
    public Integer getChlId() {
        return chlId;
    }
 
    public void setChlId(Integer chlId) {
        this.chlId = chlId;
    }
 
    public String getCusCode() {
        return cusCode;
    }
 
    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }
 
    public String getChlCode() {
        return chlCode;
    }
 
    public void setChlCode(String chlCode) {
        this.chlCode = chlCode;
    }
 
    public String getChlTime() {
        return chlTime;
    }
 
    public void setChlTime(String chlTime) {
        this.chlTime = chlTime;
    }
 
    public String getChlDate() {
        return chlDate;
    }
 
    public void setChlDate(String chlDate) {
        this.chlDate = chlDate;
    }
 
    public String getCusMobile() {
        return cusMobile;
    }
 
    public void setCusMobile(String cusMobile) {
        this.cusMobile = cusMobile;
    }
 
    public String getNickName() {
        return nickName;
    }
 
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
 
    public Integer getGrade() {
        return grade;
    }
 
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
 
    public Integer getChlSex() {
        return chlSex;
    }
 
    public void setChlSex(Integer chlSex) {
        this.chlSex = chlSex;
    }
 
    public Integer getChlAge() {
        return chlAge;
    }
 
    public void setChlAge(Integer chlAge) {
        this.chlAge = chlAge;
    }
 
    public String getChlStar() {
        return chlStar;
    }
 
    public void setChlStar(String chlStar) {
        this.chlStar = chlStar;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getImgUrl() {
        return imgUrl;
    }
 
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
}
