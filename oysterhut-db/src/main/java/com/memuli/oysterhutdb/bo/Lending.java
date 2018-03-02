package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

/* 放款交易流水表 放款交易流水表 */
public class Lending extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 交易ID 自增长 **/
	private Integer trdId;
	/** 放款交易流水号 **/
	private String trdNum;
	/** 借款人客户号 **/
	private String cusCode;
	/** 借款人二级交易账号 **/
	private String accCode;
	/** 产品编号 **/
	private String prdCode;
	/** 放款总金额 **/
	private BigDecimal trdAmount;
	/** 抵扣（红包）支付金额 **/
	private BigDecimal dedAmount;
	/** 放款日期 yyyy-mm-dd **/
	private String trdDate;
	/** 预交易时间 **/
	private String preTime;
	/** 完成时间 **/
	private String endTime;
	/** 状态 状态 0 未放款、1 放款处理中、2 投资人已放款 3备付金转账中 8 放款成功 **/
	private String status;
	/** 前置状态 **/
	private String oldStatus;
	/** 计划是否生成 0#未生成 1#已生成 **/
	private Integer shdStatus;	
	/** 提现状态 0 未提现、1 已提现 **/
	private Integer wdStatus;
	/** 提现交易流水号 **/
	private String wdTrdNum;

	public Integer getWdStatus() {
		return wdStatus;
	}

	public void setWdStatus(Integer wdStatus) {
		this.wdStatus = wdStatus;
	}

	public Integer getTrdId() {
		return trdId;
	}

	public void setTrdId(Integer trdId) {
		this.trdId = trdId;
	}

	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
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

	public BigDecimal getTrdAmount() {
		return trdAmount;
	}

	public void setTrdAmount(BigDecimal trdAmount) {
		this.trdAmount = trdAmount;
	}

	public BigDecimal getDedAmount() {
		return dedAmount;
	}

	public void setDedAmount(BigDecimal dedAmount) {
		this.dedAmount = dedAmount;
	}

	public String getTrdDate() {
		return trdDate;
	}

	public void setTrdDate(String trdDate) {
		this.trdDate = trdDate;
	}

	public String getPreTime() {
		return preTime;
	}

	public void setPreTime(String preTime) {
		this.preTime = preTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(String oldStatus) {
		this.oldStatus = oldStatus;
	}

	public Integer getShdStatus() {
		return shdStatus;
	}

	public void setShdStatus(Integer shdStatus) {
		this.shdStatus = shdStatus;
	}

	public String getWdTrdNum() {
		return wdTrdNum;
	}

	public void setWdTrdNum(String wdTrdNum) {
		this.wdTrdNum = wdTrdNum;
	}
}
