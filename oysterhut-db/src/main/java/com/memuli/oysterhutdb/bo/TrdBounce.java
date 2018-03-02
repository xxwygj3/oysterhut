package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

/**退票流水表
 * @author Jolion
 * @date 2017年6月29日下午4:43:55
 */
public class TrdBounce extends BaseEntity {
	private static final long serialVersionUID = 1L;
    /** 交易ID **/
	private Integer trdId;
	/** 退款交易流水号 **/
	private String trdNum;
	/** 投资人编号 **/
	private String cusCode;
	/** 原交易流水号 **/
	private String oldTrdNum;
	/** 退款金额 **/
	private BigDecimal trdAmount;
	/** 交易日期 yyyy-mm-dd **/
	private String trdDate;
	/** 预交易时间 **/
	private String preTime;
	/** 完成时间 **/
	private String endTime;
	/** 状态 0 交易待处理、1 交易处理中、8 交易成功、9 交易失败 **/
	private String status;
	/** 失败信息 **/
	private String failedMsg;
	/** 通道交易流水号 **/
	private String chlTrdNum;
	/** 记账流水号**/
	private String accTrdNum;
	/** 记账状态 0 未记账、1 已记账 **/
	private Integer accTrdStatus;
	/** 记账时间 记账时间 **/
	private String accTrdTime;
	/** 退票类型 1 提现退票 **/
	private Integer trdType;
	/** 退款理由**/
	private String reason;

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

	public String getStrTrdAmount() {
		return trdAmount==null?null:trdAmount.toPlainString();
	}

	public void setTrdAmount(BigDecimal trdAmount) {
		this.trdAmount = trdAmount;
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

	public String getFailedMsg() {
		return failedMsg;
	}

	public void setFailedMsg(String failedMsg) {
		this.failedMsg = failedMsg;
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

	public Integer getTrdType() {
		return trdType;
	}

	public void setTrdType(Integer trdType) {
		this.trdType = trdType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public BigDecimal getTrdAmount() {
		return trdAmount;
	}
	
	public String getOldTrdNum() {
		return oldTrdNum;
	}

	public void setOldTrdNum(String oldTrdNum) {
		this.oldTrdNum = oldTrdNum;
	}
}
