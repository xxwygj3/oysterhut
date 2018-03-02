package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.util.List;

public class Recon extends BaseEntity{
	
	private static final long serialVersionUID = 920881675848841474L;

	/** 交易属性 **/
	private String TradeType;
	
	/** 订单集合 **/
	private List<ReconOrder> orderList;

	public String getTradeType() {
		return TradeType;
	}

	public void setTradeType(String tradeType) {
		TradeType = tradeType;
	}

	public List<ReconOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ReconOrder> orderList) {
		this.orderList = orderList;
	}
}
