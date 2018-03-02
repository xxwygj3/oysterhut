package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

/* 标的汇总信息表 标的汇总信息表 */
public class PrdSummary extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/** 汇总ID 汇总ID **/
	private Integer sumId;
	/** 标的编号 标的编号 **/
	private String prdCode;
	/** 二级交易账号 二级交易账号 **/
	private String accCode;
	/** 客户号 客户号 **/
	private String cusCode;
	/** 已还款金额 已还款金额 **/
	private BigDecimal amoAmount;
	/** 已代偿金额 已代偿金额 **/
	private BigDecimal comAmount;
	/** 已收取借款人手续费 已收取借款人手续费 **/
	private BigDecimal borFee;
	/** 已收取投资人手续费 已收取投资人手续费 **/
	private BigDecimal invFee;
	/** 总投标人数 总投标人数 **/
	private Integer invCount;
	/** 已募集金额 已募集金额 **/
	private BigDecimal colAmount;
	/** 已募集百分比 **/
	private Integer colPercent;
	/** 实际募集金额=募集金额-红包支付金额 **/
	private BigDecimal rColAmount;
	/** 已放款金额 已放款金额 **/
	private BigDecimal lenAmount;
	/** 最后一次还款日期 yyyy-mm-dd **/
	private String lastRepayDate;
	/** 标的金额 **/
	private BigDecimal prdAmount;

	public PrdSummary() {

	}

	// 汇总ID 汇总ID
	public Integer getSumId() {
		return sumId;
	}

	public void setSumId(Integer value) {
		this.sumId = value;
	}

	// 标的编号 标的编号
	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String value) {
		this.prdCode = value;
	}

	// 二级交易账号 二级交易账号
	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String value) {
		this.accCode = value;
	}

	// 客户号 客户号
	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String value) {
		this.cusCode = value;
	}

	// 已还款金额 已还款金额
	public BigDecimal getAmoAmount() {
		return amoAmount;
	}

	public void setAmoAmount(BigDecimal value) {
		this.amoAmount = value;
	}

	// 已代偿金额 已代偿金额
	public BigDecimal getComAmount() {
		return comAmount;
	}

	public void setComAmount(BigDecimal value) {
		this.comAmount = value;
	}

	// 已收取借款人手续费 已收取借款人手续费
	public BigDecimal getBorFee() {
		return borFee;
	}

	public void setBorFee(BigDecimal value) {
		this.borFee = value;
	}

	// 已收取投资人手续费 已收取投资人手续费
	public BigDecimal getInvFee() {
		return invFee;
	}

	public void setInvFee(BigDecimal value) {
		this.invFee = value;
	}

	// 总投标人数 总投标人数
	public Integer getInvCount() {
		return invCount;
	}

	public void setInvCount(Integer value) {
		this.invCount = value;
	}

	// 已募集金额 已募集金额
	public BigDecimal getColAmount() {
		return colAmount;
	}

	public void setColAmount(BigDecimal value) {
		this.colAmount = value;
	}

	// 已募集百分比
	public Integer getColPercent() {
		return colPercent;
	}

	public void setColPercent(Integer value) {
		this.colPercent = value;
	}

	// 已放款金额 已放款金额
	public BigDecimal getLenAmount() {
		return lenAmount;
	}

	public void setLenAmount(BigDecimal value) {
		this.lenAmount = value;
	}

	// 最后一次还款日期 yyyy-mm-dd
	public String getLastRepayDate() {
		return lastRepayDate;
	}

	public void setLastRepayDate(String value) {
		this.lastRepayDate = value;
	}

	public BigDecimal getrColAmount() {
		return rColAmount;
	}

	public void setrColAmount(BigDecimal rColAmount) {
		this.rColAmount = rColAmount;
	}

	public BigDecimal getPrdAmount() {
		return prdAmount;
	}

	public void setPrdAmount(BigDecimal prdAmount) {
		this.prdAmount = prdAmount;
	}
}
