package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

/* 还款计划表 还款计划表 */
public class PrdRepayment extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 标的ID **/
	private Integer prdId;
	/** 标的名称 **/
	private String prdName;
	
	/** 还款计划ID 还款计划ID **/
	private Integer repId;
	/** 二级交易账号 二级交易账号 **/
	private String accCode;
	/** 客户号 借款人（用户）编号 **/
	private String cusCode;
	/** 标的编号 标的编号 **/
	private String prdCode;
	/** 还款期数 还款期数 **/
	private String repNum;
	/** 还款日期 yyyy-mm-dd **/
	private String repDate;
	/** 应还本金 应还本金 **/
	private BigDecimal capital;
	/** 应还利息 应还利息 **/
	private BigDecimal interests;
	/** 应付手续费 应付手续费 **/
	private BigDecimal fee;
	/** 应付总金额 应付总金额 **/
	private BigDecimal totalAmount;
	/** 状态 0 待还款、1 还款确认中、2 已确认 3 还款中、4 正常还款 **/
	private String status;
	/** 实还本金 实还本金 **/
	private BigDecimal realCapital;
	/** 实还利息 实还利息 **/
	private BigDecimal realInterests;
	/** 实付手续费 实付手续费 **/
	private BigDecimal realFee;
	/** 是否代偿 0 否、1 是 一期默认为0 **/
	private Integer isGuaranteed;
	/** 计划生成时间 yyyy-mm-dd hh24:mi:ss **/
	private String repTime;
	/** 实还日期 **/
	private String realRepDate;
	/*剩余本金*/
	private BigDecimal remainingCapital;
	/** 平台给付利息 **/
	private BigDecimal pInterests;

	

	public BigDecimal getRemainingCapital() {
		return remainingCapital;
	}

	public void setRemainingCapital(BigDecimal remainingCapital) {
		this.remainingCapital = remainingCapital;
	}

	public PrdRepayment() {

	}

	// 还款计划ID 还款计划ID
	public Integer getRepId() {
		return repId;
	}

	public void setRepId(Integer value) {
		this.repId = value;
	}

	// 二级交易账号 二级交易账号
	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String value) {
		this.accCode = value;
	}

	// 客户号 借款人（用户）编号
	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String value) {
		this.cusCode = value;
	}

	// 标的编号 标的编号
	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String value) {
		this.prdCode = value;
	}

	// 还款期数 还款期数
	public String getRepNum() {
		return repNum;
	}

	public void setRepNum(String value) {
		this.repNum = value;
	}

	// 还款日期 yyyy-mm-dd

	public String getRepDate() {
		return repDate;
	}

	public void setRepDate(String repDate) {
		this.repDate = repDate;
	}

	// 应还本金 应还本金
	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal value) {
		this.capital = value;
	}

	// 应还利息 应还利息
	public BigDecimal getInterests() {
		return interests;
	}

	public void setInterests(BigDecimal value) {
		this.interests = value;
	}

	// 应付手续费 应付手续费
	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal value) {
		this.fee = value;
	}

	// 应付总金额 应付总金额
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal value) {
		this.totalAmount = value;
	}

	// 状态 0 待还款、1 还款中、2 正常还款、3 代偿
	public String getStatus() {
		return status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	// 实还本金 实还本金
	public BigDecimal getRealCapital() {
		return realCapital;
	}

	public void setRealCapital(BigDecimal value) {
		this.realCapital = value;
	}

	// 实还利息 实还利息
	public BigDecimal getRealInterests() {
		return realInterests;
	}

	public void setRealInterests(BigDecimal value) {
		this.realInterests = value;
	}

	// 实付手续费 实付手续费
	public BigDecimal getRealFee() {
		return realFee;
	}

	public void setRealFee(BigDecimal value) {
		this.realFee = value;
	}

	// 是否代偿 0 否、1 是 一期默认为0
	public Integer getIsGuaranteed() {
		return isGuaranteed;
	}

	public void setIsGuaranteed(Integer value) {
		this.isGuaranteed = value;
	}

	// 计划生成时间 yyyy-mm-dd hh24:mi:ss
	public String getRepTime() {
		return repTime;
	}

	public void setRepTime(String value) {
		this.repTime = value;
	}

	public String getRealRepDate() {
		return realRepDate;
	}

	public void setRealRepDate(String realRepDate) {
		this.realRepDate = realRepDate;
	}

	public Integer getPrdId() {
		return prdId;
	}

	public void setPrdId(Integer prdId) {
		this.prdId = prdId;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public BigDecimal getpInterests() {
		return pInterests;
	}

	public void setpInterests(BigDecimal pInterests) {
		this.pInterests = pInterests;
	}
	
}
