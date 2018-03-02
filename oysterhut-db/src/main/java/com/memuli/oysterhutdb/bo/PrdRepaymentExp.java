package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

public class PrdRepaymentExp extends BaseEntity {

	private static final long serialVersionUID = 1L;
	// 还款计划预期ID
	private Integer repId;
	// 二级交易账号
	private String accCode;
	// 借款人编号
	private String cusCode;
	// 标的编号
	private String prdCode;
	// 还款期数
	private String repNum;
	// 还款日期
	private String repDate;
	// 应还本金
	private BigDecimal capital;
	// 应还利息
	private BigDecimal interests;
	// 平台给付利息
	private BigDecimal pInterests;
	// 应付手续费
	private BigDecimal fee;
	// 应付总金额
	private BigDecimal totalAmount;
	// 状态 0 有效、1 无效
	private String status;
	// 剩余本金
	private BigDecimal remainingCapital;

	public BigDecimal getRemainingCapital() {
		return remainingCapital;
	}

	public void setRemainingCapital(BigDecimal remainingCapital) {
		this.remainingCapital = remainingCapital;
	}

	public Integer getRepId() {
		return repId;
	}

	public void setRepId(Integer repId) {
		this.repId = repId;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}

	public String getRepNum() {
		return repNum;
	}

	public void setRepNum(String repNum) {
		this.repNum = repNum;
	}

	public String getRepDate() {
		return repDate;
	}

	public void setRepDate(String repDate) {
		this.repDate = repDate;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public BigDecimal getInterests() {
		return interests;
	}

	public void setInterests(BigDecimal interests) {
		this.interests = interests;
	}

	public BigDecimal getpInterests() {
		return pInterests;
	}

	public void setpInterests(BigDecimal pInterests) {
		this.pInterests = pInterests;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
