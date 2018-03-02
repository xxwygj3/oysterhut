package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class CardBin extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	/** 银行名称**/
	private String bankName;
	/** BIN值**/
	private String binValue;
	/** 卡号长度 **/
	private Integer cardLength;
	
	public Integer getCardLength() {
		return cardLength;
	}
	public void setCardLength(Integer cardLength) {
		this.cardLength = cardLength;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBinValue() {
		return binValue;
	}
	public void setBinValue(String binValue) {
		this.binValue = binValue;
	}
	
}
