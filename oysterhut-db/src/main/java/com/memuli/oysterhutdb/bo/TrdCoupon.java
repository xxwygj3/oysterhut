package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
public class TrdCoupon extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
    
    /** 优惠信息ID **/
    private Integer cuspId;
    /** 优惠信息流水号 **/
    private String cpnNum;
    /** 优惠券编号 **/
    private String cpnCode;
    /** 用户编号 **/
    private String cusCode;
    /** 优惠券发放时间 yyyy-MM-dd HH:mi:ss **/
    private String createTime;
    /** 优惠券使用时间 yyyy-MM-dd HH:mi:ss **/
    private String trdTime;
    /** 优惠券失效时间 yyyy-MM-dd HH:mi:ss **/
    private String invalidTime;
    /** 优惠券状态 0、未使用 1、已使用 2、已失效 **/
    private Integer status;
    /** 备注 **/
    private String remark;
    /** 交易编号 **/
    private String trdNum;
    /** 优惠券来源 **/
    private String cpnOrigin;
 
    public Integer getCuspId() {
        return cuspId;
    }
 
    public void setCuspId(Integer cuspId) {
        this.cuspId = cuspId;
    }
 
    public String getCpnNum() {
        return cpnNum;
    }
 
    public void setCpnNum(String cpnNum) {
        this.cpnNum = cpnNum;
    }
 
    public String getCpnCode() {
        return cpnCode;
    }
 
    public void setCpnCode(String cpnCode) {
        this.cpnCode = cpnCode;
    }
 
    public String getCusCode() {
        return cusCode;
    }
 
    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }
 
    public String getCreateTime() {
        return createTime;
    }
 
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
 
    public String getTrdTime() {
        return trdTime;
    }
 
    public void setTrdTime(String trdTime) {
        this.trdTime = trdTime;
    }
 
    public Integer getStatus() {
        return status;
    }
 
    public void setStatus(Integer status) {
        this.status = status;
    }
 
    public String getRemark() {
        return remark;
    }
 
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	public String getCpnOrigin() {
		return cpnOrigin;
	}

	public void setCpnOrigin(String cpnOrigin) {
		this.cpnOrigin = cpnOrigin;
	}

	public String getInvalidTime() {
		return invalidTime;
	}

	public void setInvalidTime(String invalidTime) {
		this.invalidTime = invalidTime;
	}
 
}
