package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

/* 还款交易流水表 */
public class TrdRepayment extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 交易ID 交易ID **/
	private Integer trdId;
	/** 交易流水号 交易流水号 **/
	private String trdNum;
	/** 银行网关流水号 **/
	private String chlTrdNum;
	/** 账户网关流水号 **/
	private String accTrdNum;
	/** 账户状态 **/
	private Integer accTrdStatus;
	/** 标的编号 标的编号 **/
	private String prdCode;
	/** 借款人二级交易账号 借款人二级交易账号 **/
	private String borAccCode;
	/** 借款人客户号 借款人客户号 **/
	private String borCusCode;
	/** 还款人二级交易账号 还款人二级交易账号 **/
	private String repAccCode;
	/** 还款人客户号 还款人客户号 **/
	private String repCusCode;
	/** 还款本金 还款本金 **/
	private BigDecimal capital;
	/** 还款利息 还款利息 **/
	private BigDecimal interests;
	/** 借款手续费 借款时确定每次还款应还手续费 **/
	private BigDecimal borFee;
	/** 还款操作手续费 还款额外手续费 **/
	private BigDecimal repFee;
	/** 滞纳金 滞纳金 **/
	private BigDecimal lateFee;
	/** 状态 0 交易处理中、1 交易成功、9 交易失败 **/
	private String status;
	/** 还款计划ID 还款计划ID **/
	private Integer prdRepId;
	/** 还款日期 yyyy-mm-dd **/
	private String trdDate;
	/** 还款时间 还款时间 **/
	private String preTime;
	/** 完成时间 完成时间 **/
	private String endTime;
	/** 失败信息 失败信息 **/
	private String failedMsg;
	/** 还款备注 还款备注 **/
	private String remark;
	/** 交易类型 1 确认 2 扣款 **/
	private Integer trdType;
	/** 记账时间 **/
	private String accTrdTime;
	
	public TrdRepayment() {

	}

	// 交易ID 交易ID
	public Integer getTrdId() {
		return trdId;
	}

	public void setTrdId(Integer value) {
		this.trdId = value;
	}

	// 交易流水号 交易流水号
	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String value) {
		this.trdNum = value;
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

	// 标的编号 标的编号
	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String value) {
		this.prdCode = value;
	}

	// 借款人二级交易账号 借款人二级交易账号
	public String getBorAccCode() {
		return borAccCode;
	}

	public void setBorAccCode(String value) {
		this.borAccCode = value;
	}

	// 借款人客户号 借款人客户号
	public String getBorCusCode() {
		return borCusCode;
	}

	public void setBorCusCode(String value) {
		this.borCusCode = value;
	}

	// 还款人二级交易账号 还款人二级交易账号
	public String getRepAccCode() {
		return repAccCode;
	}

	public void setRepAccCode(String value) {
		this.repAccCode = value;
	}

	// 还款人客户号 还款人客户号
	public String getRepCusCode() {
		return repCusCode;
	}

	public void setRepCusCode(String value) {
		this.repCusCode = value;
	}

	// 还款本金 还款本金
	public String getStrCapital() {
		return capital==null?null:capital.toPlainString();
	}

	public void setCapital(BigDecimal value) {
		this.capital = value;
	}

	// 还款利息 还款利息
	public String getStrInterests() {
		return interests==null?null:interests.toPlainString();
	}

	public void setInterests(BigDecimal value) {
		this.interests = value;
	}

	// 借款手续费 借款时确定每次还款应还手续费
	public String getStrBorFee() {
		return borFee==null?null:borFee.toPlainString();
	}

	public void setBorFee(BigDecimal value) {
		this.borFee = value;
	}

	// 还款操作手续费 还款额外手续费
	public String getStrRepFee() {
		return repFee==null?null:repFee.toPlainString();
	}

	public void setRepFee(BigDecimal value) {
		this.repFee = value;
	}

	// 滞纳金 滞纳金
	public String getStrLateFee() {
		return lateFee==null?null:lateFee.toPlainString();
	}

	public void setLateFee(BigDecimal value) {
		this.lateFee = value;
	}

	// 状态 0 交易处理中、1 交易成功、9 交易失败
	public String getStatus() {
		return status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	// 还款计划ID 还款计划ID
	public Integer getPrdRepId() {
		return prdRepId;
	}

	public void setPrdRepId(Integer value) {
		this.prdRepId = value;
	}

	// 还款日期 yyyy-mm-dd
	public String getTrdDate() {
		return trdDate;
	}

	public void setTrdDate(String value) {
		this.trdDate = value;
	}

	// 还款时间 还款时间
	public String getPreTime() {
		return preTime;
	}

	public void setPreTime(String value) {
		this.preTime = value;
	}

	// 完成时间 完成时间
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String value) {
		this.endTime = value;
	}

	// 失败信息 失败信息
	public String getFailedMsg() {
		return failedMsg;
	}

	public void setFailedMsg(String value) {
		this.failedMsg = value;
	}

	// 还款备注 还款备注
	public String getRemark() {
		return remark;
	}

	public void setRemark(String value) {
		this.remark = value;
	}

	public Integer getTrdType() {
		return trdType;
	}

	public void setTrdType(Integer trdType) {
		this.trdType = trdType;
	}

	public String getAccTrdTime() {
		return accTrdTime;
	}

	public void setAccTrdTime(String accTrdTime) {
		this.accTrdTime = accTrdTime;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public BigDecimal getInterests() {
		return interests;
	}

	public BigDecimal getBorFee() {
		return borFee;
	}

	public BigDecimal getRepFee() {
		return repFee;
	}

	public BigDecimal getLateFee() {
		return lateFee;
	}
}
