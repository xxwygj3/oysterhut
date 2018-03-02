package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

/* 收益计划表 收益计划表 */
public class PrdIncome extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 收益ID 自增长 收益ID **/
	private Integer incId;
	/** 二级交易账号 二级交易账号 **/
	private String accCode;
	/** 标的编号 标的编号 **/
	private String prdCode;
	/** 收益期数 收益期数 **/
	private Integer incNum;
	/** 投资人编号 投资人编号 **/
	private String cusCode;
	/** 投资交易流水号 投资交易流水号 **/
	private String invTrdNum;
	/** 还款计划ID 还款计划ID **/
	private Integer objRepId;
	/** 收益日期 yyyy-mm-dd **/
	private String incDate;
	/** 应收本金 应收本金 **/
	private BigDecimal capital;
	/** 应收利息 应收利息 **/
	private BigDecimal interests;
	/** 应付手续费 应付手续费 **/
	private BigDecimal fee;
	/** 状态 0 待收、1 已收 **/
	private String status;
	/** 实收本金 实收本金 **/
	private BigDecimal realCapital;
	/** 实收利息 实收利息 **/
	private BigDecimal realInterests;
	/** 实付手续费 实付手续费 **/
	private BigDecimal realFee;
	/** 计划生成时间 yyyy-mm-dd hh24:mi:ss **/
	private String incTime;
	/** 实际收益时间 **/
	private String relIncDate;
	/** 平台给付利息 **/
	private BigDecimal pInterests;
	/** 到期日 **/
	private String dueDate;
	
	public PrdIncome() {

	}

	public Integer getIncId() {
		return incId;
	}

	public void setIncId(Integer incId) {
		this.incId = incId;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}

	public Integer getIncNum() {
		return incNum;
	}

	public void setIncNum(Integer incNum) {
		this.incNum = incNum;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getInvTrdNum() {
		return invTrdNum;
	}

	public void setInvTrdNum(String invTrdNum) {
		this.invTrdNum = invTrdNum;
	}

	public Integer getObjRepId() {
		return objRepId;
	}

	public void setObjRepId(Integer objRepId) {
		this.objRepId = objRepId;
	}

	public String getIncDate() {
		return incDate;
	}

	public void setIncDate(String incDate) {
		this.incDate = incDate;
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

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getRealCapital() {
		return realCapital;
	}

	public void setRealCapital(BigDecimal realCapital) {
		this.realCapital = realCapital;
	}

	public BigDecimal getRealInterests() {
		return realInterests;
	}

	public void setRealInterests(BigDecimal realInterests) {
		this.realInterests = realInterests;
	}

	public BigDecimal getRealFee() {
		return realFee;
	}

	public void setRealFee(BigDecimal realFee) {
		this.realFee = realFee;
	}

	public String getIncTime() {
		return incTime;
	}

	public void setIncTime(String incTime) {
		this.incTime = incTime;
	}

	public String getRelIncDate() {
		return relIncDate;
	}

	public void setRelIncDate(String relIncDate) {
		this.relIncDate = relIncDate;
	}

	public BigDecimal getpInterests() {
		return pInterests;
	}

	public void setpInterests(BigDecimal pInterests) {
		this.pInterests = pInterests;
	}

	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
}
