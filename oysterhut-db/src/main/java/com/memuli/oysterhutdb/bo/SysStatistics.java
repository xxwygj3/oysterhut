package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

/** 平台数据统计表 **/
public class SysStatistics extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
    /** 统计ID 自增长 **/
    private Integer stsId;
    /** 统计项目关键字 **/
    private String stsKey;
    /** 统计值 **/
    private BigDecimal stsNum;
    /** 统计描述 **/
    private String stsName;
    /** 统计日期(yyyy-mm-dd) **/
    private String stsDate;
    /** 统计时间(yyyy-mm-dd hh:mm:ss) **/
    private String stsTime;
 
    public Integer getStsId() {
        return stsId;
    }
 
    public void setStsId(Integer stsId) {
        this.stsId = stsId;
    }
 
    public String getStsKey() {
        return stsKey;
    }
 
    public void setStsKey(String stsKey) {
        this.stsKey = stsKey;
    }
 
    public BigDecimal getStsNum() {
        return stsNum;
    }
 
    public void setStsNum(BigDecimal stsNum) {
        this.stsNum = stsNum;
    }
 
    public String getStsName() {
        return stsName;
    }
 
    public void setStsName(String stsName) {
        this.stsName = stsName;
    }
 
    public String getStsDate() {
        return stsDate;
    }
 
    public void setStsDate(String stsDate) {
        this.stsDate = stsDate;
    }
 
    public String getStsTime() {
        return stsTime;
    }
 
    public void setStsTime(String stsTime) {
        this.stsTime = stsTime;
    }
 

}
