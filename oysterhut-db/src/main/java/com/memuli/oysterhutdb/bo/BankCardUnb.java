package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/* 客户银行卡解绑流水表 */
public class BankCardUnb extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 解绑ID **/
	private Integer unbId;
	/** 客户编号 关联客户编号 **/
	private String cusCode;
	/** 银行账号 **/
	private String cardNum;
	/** 银行号 **/
	private String bankCode;
	/** 绑卡流水号 **/
	private String trdNumBind;
	/** 解绑流水号 **/
	private String trdNum;
	/** 网关交易流水号 **/
	private String chlTrdNum;
	/** 预交易时间 **/
	private String preTime;
	/** 完成交易时间 **/
	private String endTime;
	/** 状态 **/
	private String status;
	/** 失败信息 **/
	private String failedMsg;

	public Integer getUnbId() {
		return unbId;
	}

	public void setUnbId(Integer unbId) {
		this.unbId = unbId;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getTrdNumBind() {
		return trdNumBind;
	}

	public void setTrdNumBind(String trdNumBind) {
		this.trdNumBind = trdNumBind;
	}

	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	public String getChlTrdNum() {
		return chlTrdNum;
	}

	public void setChlTrdNum(String chlTrdNum) {
		this.chlTrdNum = chlTrdNum;
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

}
