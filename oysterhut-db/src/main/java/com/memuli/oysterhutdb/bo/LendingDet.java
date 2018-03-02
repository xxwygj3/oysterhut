package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

public class LendingDet extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 交易ID 自增长 **/
	private Integer trdId;
	/** 放款明细流水号 标的交易流水 **/
	private String trdNum;
	/** 放款交易流水号 **/
	private String lnTrdNum;
	/** 解冻订单号 **/
	private String unFreezeId;
	/** 放款金额 放款金额 **/
	private BigDecimal trdAmount;
	/** 手续费 **/
	private BigDecimal trdFee;
	/** 交易日期 yyyy-mm-dd **/
	private String trdDate;
	/** 状态 0 交易处理中、8 交易成功、9 交易失败 **/
	private String status;
	/** 预交易时间 yyyy-mm-dd hh24:mi:ss **/
	private String preTime;
	/** 完成交易时间 yyyy-mm-dd hh24:mi:ss **/
	private String endTime;
	/** 通道交易流水号 **/
	private String chlTrdNum;
	/** 通道返回信息 **/
	private String failedMSg;
	/** 前置状态 **/
	private String oldStatus;
	/** 记账流水号 **/
	private String accTrdNum;
	/** 记账状态 0.未记账 1.已记账 **/
	private Integer accTrdStatus;
	/** 记账时间 **/
	private String accTrdTime;
	/** 投资交易流水号 **/
	private String inTrdNum;
	/** 投资人客户号 **/
	private String cusCode;
	/** 体验金金额 **/
	private BigDecimal dedAmount;

	public String getUnFreezeId() {
		return unFreezeId;
	}

	public void setUnFreezeId(String unFreezeId) {
		this.unFreezeId = unFreezeId;
	}

	public String getInTrdNum() {
		return inTrdNum;
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

	public String getLnTrdNum() {
		return lnTrdNum;
	}

	public void setLnTrdNum(String lnTrdNum) {
		this.lnTrdNum = lnTrdNum;
	}

	public BigDecimal getTrdAmount() {
		return trdAmount;
	}

	public void setTrdAmount(BigDecimal trdAmount) {
		this.trdAmount = trdAmount;
	}

	public BigDecimal getTrdFee() {
		return trdFee;
	}

	public void setTrdFee(BigDecimal trdFee) {
		this.trdFee = trdFee;
	}

	public String getTrdDate() {
		return trdDate;
	}

	public void setTrdDate(String trdDate) {
		this.trdDate = trdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getChlTrdNum() {
		return chlTrdNum;
	}

	public void setChlTrdNum(String chlTrdNum) {
		this.chlTrdNum = chlTrdNum;
	}

	public String getFailedMSg() {
		return failedMSg;
	}

	public void setFailedMSg(String failedMSg) {
		this.failedMSg = failedMSg;
	}

	public String getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(String oldStatus) {
		this.oldStatus = oldStatus;
	}

	public String getAccTrdNum() {
		return accTrdNum;
	}

	public void setAccTrdNum(String accTrdNum) {
		this.accTrdNum = accTrdNum;
	}

	public Integer getAccTrdStatus() {
		return accTrdStatus;
	}

	public void setAccTrdStatus(Integer accTrdStatus) {
		this.accTrdStatus = accTrdStatus;
	}

	public String getAccTrdTime() {
		return accTrdTime;
	}

	public void setAccTrdTime(String accTrdTime) {
		this.accTrdTime = accTrdTime;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public BigDecimal getDedAmount() {
		return dedAmount;
	}

	public void setDedAmount(BigDecimal dedAmount) {
		this.dedAmount = dedAmount;
	}

	public void setInTrdNum(String inTrdNum) {
		this.inTrdNum = inTrdNum;
	}

}
