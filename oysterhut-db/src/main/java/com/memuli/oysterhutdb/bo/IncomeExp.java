package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

public class IncomeExp extends BaseEntity {

	private static final long serialVersionUID = 574003804691627858L;
	/** 预期收益id */
	private Integer incId;
	/** 二级交易账号 */
	private String accCode;
	/** 标的编号 */
	private String prdCode;
	/** 收益期数 */
	private Integer incNum;
	/** 投资人编号 */
	private String cusCode;
	/** 投资交易流水号 */
	private String invTrdNum;
	/** 还款计划ID */
	private Integer objRepId;
	/** 应收日期 */
	private String incDate;
	/** 应收本金 */
	private BigDecimal capital;
	/** 应收利息 */
	private BigDecimal interests;
	/** 平台给付利息 */
	private BigDecimal pInterests;
	/** 应付手续费 */
	private BigDecimal fee;
	/** 状态 0 有效、1 无效 */
	private String status;
	/** 剩余本金 */
	private BigDecimal remainingCapital;
	/** 到期日 */
	private String dueDate;

	public String getStrRemainingCapital() {
		return remainingCapital==null?null:remainingCapital.toPlainString();
	}

	public void setRemainingCapital(BigDecimal remainingCapital) {
		this.remainingCapital = remainingCapital;
	}

	public Integer getIncId() {
		return incId;
	}

	public void setIncId(Integer incId) {
		this.incId = incId;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}

	public Integer getIncNum() {
		return incNum;
	}

	public void setIncNum(Integer incNum) {
		this.incNum = incNum;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getInvTrdNum() {
		return invTrdNum;
	}

	public void setInvTrdNum(String invTrdNum) {
		this.invTrdNum = invTrdNum;
	}

	public Integer getObjRepId() {
		return objRepId;
	}

	public void setObjRepId(Integer objRepId) {
		this.objRepId = objRepId;
	}

	public String getIncDate() {
		return incDate;
	}

	public void setIncDate(String incDate) {
		this.incDate = incDate;
	}

	public String getStrCapital() {
		return capital==null?null:capital.toPlainString();
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public String getStrInterests() {
		return interests==null?null:interests.toPlainString();
	}

	public void setInterests(BigDecimal interests) {
		this.interests = interests;
	}

	public String getStrpInterests() {
		return pInterests==null?null:pInterests.toPlainString();
	}

	public void setpInterests(BigDecimal pInterests) {
		this.pInterests = pInterests;
	}

	public String getStrFee() {
		return fee==null?null:fee.toPlainString();
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public BigDecimal getInterests() {
		return interests;
	}

	public BigDecimal getpInterests() {
		return pInterests;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public BigDecimal getRemainingCapital() {
		return remainingCapital;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
}


