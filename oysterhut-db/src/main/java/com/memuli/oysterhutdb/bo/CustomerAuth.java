package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/**
 * 客户认证信息表
 */
public class CustomerAuth extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/** 用户编号 **/
	private String cusCode;
	/** 第三方资金托管平台是否已认证 0 否、1 是 **/
	private Integer tpStatus;
	/** 邮件是否已认证 0 否、1 是 **/
	private Integer emailStatus;
	/** 手机是否已认证 0 否、1 是 **/
	private Integer mobileStatus;
	/** 银行卡是否已认证 0 否、1 是 **/
	private Integer bankCardStatus;
	public Integer getBankCardStatus() {
		return bankCardStatus;
	}

	public void setBankCardStatus(Integer bankCardStatus) {
		this.bankCardStatus = bankCardStatus;
	}

	/** 资料完善程度 资料完善程度百分比 **/
	private Integer perfectPercent;
	
	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public Integer getTpStatus() {
		return tpStatus;
	}

	public void setTpStatus(Integer tpStatus) {
		this.tpStatus = tpStatus;
	}

	public Integer getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(Integer emailStatus) {
		this.emailStatus = emailStatus;
	}

	public Integer getMobileStatus() {
		return mobileStatus;
	}

	public void setMobileStatus(Integer mobileStatus) {
		this.mobileStatus = mobileStatus;
	}

	public Integer getPerfectPercent() {
		return perfectPercent;
	}

	public void setPerfectPercent(Integer perfectPercent) {
		this.perfectPercent = perfectPercent;
	}

}
