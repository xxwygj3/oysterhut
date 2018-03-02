package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
/**
 * 银行充值限额详细表
 */
public class SysBankDet extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String bankId;
	/** 银行编号 **/
	private String bankCode;
	/** 支持卡种 **/
	private String bankType;
	/** 单笔限额 **/
	private String singleLimit;
	/** 每日限额 **/
	private String dailyLimit;
	/** 满足条件 **/
	private String payMethod;

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getSingleLimit() {
		return singleLimit;
	}

	public void setSingleLimit(String singleLimit) {
		this.singleLimit = singleLimit;
	}

	public String getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(String dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

}
