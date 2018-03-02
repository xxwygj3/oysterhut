package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

/* 用户账务统计表 */
public class Statistics extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/** 编号 自增长 **/
	private Integer stsId;
	/** 客户编号 关联客户基本信息表 **/
	private String cusCode;
	/** 已赚金额 **/
	private BigDecimal stsIncome;
	/** 已投金额 **/
	private BigDecimal stsInvestment;
	/** 已还金额 **/
	private BigDecimal stsRepayment;
	/** 已借金额 **/
	private BigDecimal stsLoans;

	public Statistics() {
	}

	// 编号 自增长
	public Integer getstsId() {
		return stsId;
	}

	public void setstsId(Integer value) {
		this.stsId = value;
	}

	// 客户编号 关联客户基本信息表
	public String getcusCode() {
		return cusCode;
	}

	public void setcusCode(String value) {
		this.cusCode = value;
	}

	// 已赚金额
	public BigDecimal getstsIncome() {
		return stsIncome;
	}

	public void setstsIncome(BigDecimal value) {
		this.stsIncome = value;
	}

	// 已投金额
	public BigDecimal getstsInvestment() {
		return stsInvestment;
	}

	public void setstsInvestment(BigDecimal value) {
		this.stsInvestment = value;
	}

	// 已还金额
	public BigDecimal getstsRepayment() {
		return stsRepayment;
	}

	public void setstsRepayment(BigDecimal value) {
		this.stsRepayment = value;
	}

	// 已借金额
	public BigDecimal getstsLoans() {
		return stsLoans;
	}

	public void setstsLoans(BigDecimal value) {
		this.stsLoans = value;
	}

	public void reset() {
		stsId = 0;
		cusCode = null;
		stsIncome = null;
		stsInvestment = null;
		stsRepayment = null;
		stsLoans = null;
	}

	public void assignFrom(Statistics AObj) {
		if (AObj == null) {
			reset();
			return;
		}
		stsId = AObj.stsId;
		cusCode = AObj.cusCode;
		stsIncome = AObj.stsIncome;
		stsInvestment = AObj.stsInvestment;
		stsRepayment = AObj.stsRepayment;
		stsLoans = AObj.stsLoans;
	}

}
