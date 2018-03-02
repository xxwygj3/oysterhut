package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;


public class ChildRewardDet extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
    
    private Integer detId;
    /** 用户编号 **/
    private String cusCode;
    /** 领取状态(0、未领取  1、已领取) **/
    private Integer status;
    /** 奖励内容 **/
    private String rewardContent;
    /** 领取时间 **/
    private String receiveDate;
 
    public Integer getDetId() {
        return detId;
    }
 
    public void setDetId(Integer detId) {
        this.detId = detId;
    }
 
    public String getCusCode() {
        return cusCode;
    }
 
    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }
 
    public Integer getStatus() {
        return status;
    }
 
    public void setStatus(Integer status) {
        this.status = status;
    }
 
    public String getRewardContent() {
        return rewardContent;
    }
 
    public void setRewardContent(String rewardContent) {
        this.rewardContent = rewardContent;
    }
 
    public String getReceiveDate() {
        return receiveDate;
    }
 
    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }
 
}
