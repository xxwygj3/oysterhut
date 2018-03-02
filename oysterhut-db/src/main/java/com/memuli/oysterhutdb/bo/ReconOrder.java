package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class ReconOrder extends BaseEntity {
	
	private static final long serialVersionUID = -3390328743199506208L;
	/** 通道交易流水号  **/
	private String chlTrdNum;

	public String getChlTrdNum() {
		return chlTrdNum;
	}

	public void setChlTrdNum(String chlTrdNum) {
		this.chlTrdNum = chlTrdNum;
	}
}
