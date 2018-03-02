package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

/* 还款交易明细表 还款交易明细表 */
public class RepaymentDet extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/** 明细ID 自增长 **/
	private Integer detId;
	/** 还款交易明细流水号 **/
	private String trdNum;
	/** 还款交易流水号 还款交易流水号 **/
	private String repTrdNum;
	/** 还款人二级交易账号 还款人二级交易账号 **/
	private String repAccCode;
	/** 还款人编号 还款人客户号 **/
	private String repCusCode;
	/** 借款人二级交易账户号 借款人二级交易账户号 **/
	private String invAccCode;
	/** 借款人编号 借款人客户号 **/
	private String invCusCode;
	/** 入账本金 入账本金 **/
	private BigDecimal capital;
	/** 入账利息 入账利息 **/
	private BigDecimal interests;
	/** 收益计划ID **/
	private Integer incId;
	/** 银行网关流水号 **/
	private String chlTrdNum;
	/** 账户网关流水号 **/
	private String accTrdNum;
	/** 账户状态 **/
	private Integer accTrdStatus;
	/** 记账时间 **/
	private String accTrdTime;
	/** 失败信息 失败信息 **/
	private String failedMsg;
	/** 状态 0 交易处理中、1 交易成功、9 交易失败 **/
	private String status;
	/** 还款时间 还款时间 **/
	private String preTime;
	/** 完成时间 完成时间 **/
	private String endTime;

	public RepaymentDet() {
	}

	// 明细ID 自增长
	public Integer getDetId() {
		return detId;
	}

	public void setDetId(Integer value) {
		this.detId = value;
	}
	
	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	// 还款交易流水号 还款交易流水号
	public String getRepTrdNum() {
		return repTrdNum;
	}

	public void setRepTrdNum(String value) {
		this.repTrdNum = value;
	}

	// 还款人二级交易账号 还款人二级交易账号
	public String getRepAccCode() {
		return repAccCode;
	}

	public void setRepAccCode(String value) {
		this.repAccCode = value;
	}

	// 还款人编号 还款人客户号
	public String getRepCusCode() {
		return repCusCode;
	}

	public void setRepCusCode(String value) {
		this.repCusCode = value;
	}

	// 借款人二级交易账户号 借款人二级交易账户号
	public String getInvAccCode() {
		return invAccCode;
	}

	public void setInvAccCode(String value) {
		this.invAccCode = value;
	}

	// 借款人编号 借款人客户号
	public String getInvCusCode() {
		return invCusCode;
	}

	public void setInvCusCode(String value) {
		this.invCusCode = value;
	}

	// 入账本金 入账本金
	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal value) {
		this.capital = value;
	}

	// 入账利息 入账利息
	public BigDecimal getInterests() {
		return interests;
	}

	public void setInterests(BigDecimal value) {
		this.interests = value;
	}

	public Integer getIncId() {
		return incId;
	}

	public void setIncId(Integer incId) {
		this.incId = incId;
	}

	public String getChlTrdNum() {
		return chlTrdNum;
	}

	public void setChlTrdNum(String chlTrdNum) {
		this.chlTrdNum = chlTrdNum;
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

	public String getFailedMsg() {
		return failedMsg;
	}

	public void setFailedMsg(String failedMsg) {
		this.failedMsg = failedMsg;
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
}
