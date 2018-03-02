package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

/* 投资交易总表 投资交易汇总 */
public class Investment extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 交易ID 交易ID **/
	private Integer trdId;
	/** 订单号 **/
	private String trdNum;
	/** 二级交易账号 二级交易账号 **/
	private String accCode;
	/** 客户号 投资人客户号 **/
	private String cusCode;
	/** 标的编号 标的编号 **/
	private String prdCode;
	/** 投资总计金额 投资金额 **/
	private BigDecimal trdAmount;
	/** 投资总计手续费 投资手续费 **/
	private BigDecimal trdFee;
	/** 状态 0 投资中、1 收款中、2 已结束 **/
	private String status;
	/** 已收本金 已收本金 **/
	private BigDecimal capital;
	/** 已收利息 已收利息 **/
	private BigDecimal interests;
	/** 应收金额 **/
	private BigDecimal incAmount;
	/** 放款交易流水号 放款交易流水号 **/
	private String lenTrdNum;
	
	public Investment() {

	}

	// 交易ID 交易ID
	public Integer getTrdId() {
		return trdId;
	}

	public void setTrdId(Integer value) {
		this.trdId = value;
	}

	// 二级交易账号 二级交易账号
	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String value) {
		this.accCode = value;
	}

	// 客户号 投资人客户号
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

	// 投资总计金额 投资金额
	public BigDecimal getTrdAmount() {
		return trdAmount;
	}

	public void setTrdAmount(BigDecimal value) {
		this.trdAmount = value;
	}

	// 投资总计手续费 投资手续费
	public BigDecimal getTrdFee() {
		return trdFee;
	}

	public void setTrdFee(BigDecimal value) {
		this.trdFee = value;
	}

	// 状态 0 投资中、1 收款中、2 已结束
	public String getStatus() {
		return status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	// 已收本金 已收本金
	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal value) {
		this.capital = value;
	}

	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	// 已收利息 已收利息
	public BigDecimal getInterests() {
		return interests;
	}

	public void setInterests(BigDecimal value) {
		this.interests = value;
	}

	public BigDecimal getIncAmount() {
		return incAmount;
	}

	public void setIncAmount(BigDecimal incAmount) {
		this.incAmount = incAmount;
	}

	public String getLenTrdNum() {
		return lenTrdNum;
	}

	public void setLenTrdNum(String lenTrdNum) {
		this.lenTrdNum = lenTrdNum;
	}
}
