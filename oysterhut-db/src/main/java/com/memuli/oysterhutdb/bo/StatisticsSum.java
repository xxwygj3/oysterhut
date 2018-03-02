package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

public class StatisticsSum extends BaseEntity {

	private static final long serialVersionUID = 9207077899745017669L;
	/* 累计投资人数*/
	private Integer investmentCount;
	/* 累计赚取金额*/
	private BigDecimal income;
	/* 累计投资金额*/
	private BigDecimal investmentAmount;
	/* 累计已还金额*/
	private BigDecimal repaymentAmount;
	
	public Integer getInvestmentCount() {
		return investmentCount;
	}
	public void setInvestmentCount(Integer investmentCount) {
		this.investmentCount = investmentCount;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public BigDecimal getInvestmentAmount() {
		return investmentAmount;
	}
	public void setInvestmentAmount(BigDecimal investmentAmount) {
		this.investmentAmount = investmentAmount;
	}
	public BigDecimal getRepaymentAmount() {
		return repaymentAmount;
	}
	public void setRepaymentAmount(BigDecimal repaymentAmount) {
		this.repaymentAmount = repaymentAmount;
	}
}
