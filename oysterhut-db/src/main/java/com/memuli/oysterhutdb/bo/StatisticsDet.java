package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

/* 用户账务统计详情表 */
public class StatisticsDet extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer stsId;
	/** 客户编号 **/
	private String cusCode;
	/** 亲子编号 **/
	private String chlCode;
	/** 已赚金额 **/
	private BigDecimal stsIncome;
	/** 已投金额 **/
	private BigDecimal stsInvestment;
	/** 已还金额 **/
	private BigDecimal stsRepayment;
	/** 已借金额 **/
	private BigDecimal stsLoans;
	/** 待收金额 **/
	private BigDecimal stsCollect;
	/** 产品类型 **/
	private Integer prdType;

	public Integer getStsId() {
		return stsId;
	}

	public void setStsId(Integer stsId) {
		this.stsId = stsId;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getChlCode() {
		return chlCode;
	}

	public void setChlCode(String chlCode) {
		this.chlCode = chlCode;
	}

	public BigDecimal getStsIncome() {
		return stsIncome;
	}

	public void setStsIncome(BigDecimal stsIncome) {
		this.stsIncome = stsIncome;
	}

	public BigDecimal getStsInvestment() {
		return stsInvestment;
	}

	public void setStsInvestment(BigDecimal stsInvestment) {
		this.stsInvestment = stsInvestment;
	}

	public BigDecimal getStsRepayment() {
		return stsRepayment;
	}

	public void setStsRepayment(BigDecimal stsRepayment) {
		this.stsRepayment = stsRepayment;
	}

	public BigDecimal getStsLoans() {
		return stsLoans;
	}

	public void setStsLoans(BigDecimal stsLoans) {
		this.stsLoans = stsLoans;
	}

	public BigDecimal getStsCollect() {
		return stsCollect;
	}

	public void setStsCollect(BigDecimal stsCollect) {
		this.stsCollect = stsCollect;
	}

	public Integer getPrdType() {
		return prdType;
	}

	public void setPrdType(Integer prdType) {
		this.prdType = prdType;
	}

}
