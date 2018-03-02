package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

/* 标的基本信息表 标的基本信息表 */
public class Product extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 标的ID 标的ID **/
	private Integer prdId;
	/** 标的交易流水号 标的交易流水 **/
	private String trdNum;
	/** 协议编号 **/
	private Integer agrId;
	/** 标的编号 标的编号 **/
	private String prdCode;
	/** 标的名称 标的名称 **/
	private String prdName;
	/** 二级交易账号 二级交易账号 **/
	private String accCode;
	/** 客户号（借款人编号） 客户号（借款人编号） **/
	private String cusCode;
	/** 资产合同编号 资产合同编号 **/
	private String prdAgrNum;
	/** 借款申请编号 借款申请编号 **/
	private String loanTrdNum;
	/** 资产类型 1、散标 2、产品 **/
	private Integer prdNature;
	/** 活动专场 标的活动专场 1 新手专场 2 热卖专场 **/
	private Integer prdActivity;
	/** 标的类型 1 信用、2 抵押、3 应收账款转让、4 保理、5 资产转让、6 商业借款、7 月月喜、8 季季宝、9 双季礼、10 新手专享 **/
	private Integer prdType;
	/** 标的金额 标的金额 **/
	private BigDecimal prdAmount;
	/** 应还金额 借款人应还金额 **/
	private BigDecimal repayedAmount;
	/** 年化利率 年化利率 **/
	private BigDecimal rate;
	/** 固话利率 固话利率 **/
	private BigDecimal defaultRate;
	/** 奖励利率 奖励利率 **/
	private BigDecimal rewardRate;
	/** 浮动年化利率 浮动年化利率 **/
	private BigDecimal floatingRate;
	/** 借款利率 借款利率 **/
	private BigDecimal loanRate;
	/** 标的期限 标的期限 以天为单位 **/
	private Integer prdPeriod;
	/** 标的期数 标的期数 **/
	private Integer prdStage;
	/** 发布日期 标的发布审核通过日期 yyyy-mm-dd **/
	private String prdDate;
	/** 募集开始日 yyyy-mm-dd **/
	private String colBeginDate;
	/** 募集截止日 yyyy-mm-dd **/
	private String colEndDate;
	/** 募集开始时间 募集开始时间 **/
	private String colBeginTime;
	/** 募集截止时间 募集截止时间 **/
	private String colEndTime;
	/** 满标日期 满标日期 **/
	private String colFinishDate;
	/** 标的到期日 起息日+标的期限 yyyy-mm-dd **/
	private String dueDate;
	/** 起息日 默认募集截止日T+1日 yyyy-mm-dd **/
	private String valueDate;
	/** 起息日延迟天数 起息日延迟天数 **/
	private Integer valDelayDays;
	/** 还款日 yyyy-mm-dd **/
	private String repDate;
	/** 还款日延迟天数 还款日延迟天数 **/
	private Integer repDelayDays;
	/** 还款类型 1 按月等额本息、2 按月等额本金、3 按月还息到期还本、4 按季还息到期还本、5 到期一次还本付息 **/
	private Integer repType;
	/** 还款日 每月还款日 **/
	private Integer repDay;
	/** 借款保证金 借款保证金 **/
	private BigDecimal securityDeposit;
	/** 投标手续费百分比 投标手续费百分比 **/
	private BigDecimal invFeePercent;
	/** 投标手续费收取方式 0 不收取、1 放款后一次性收取、2 每月收取 **/
	private Integer invFeeType;
	/** 借款手续费百分比 借款手续费百分比 **/
	private BigDecimal borFeePercent;
	/** 借款手续费收取方式 0 不收取、1 放款后一次性收取、2 每月收取 **/
	private Integer borFeeType;
	/** 滞纳金百分比 滞纳金百分比 **/
	private BigDecimal lateFeePercent;
	/** 最低投标金额 最低投标金额 **/
	private BigDecimal minInvAmt;
	/** 单次投标增加金额 单次投标增加金额 **/
	private BigDecimal minRseAmt;
	/** 单次最大投标金额 单次最大投标金额 **/
	private BigDecimal maxInvAmt;
	/** 是否推荐 0 否、1 是 **/
	private Integer isRecommended;
	/**
	 * 状态 00 未生效、10 初审通过、11 募集中、14 放款处理中、15 流标处理中、20 还款中、30 已结束、40 已流标、98
	 * 发布审核拒绝（待重新发布）、99 发布失败
	 **/
	private String status;
	/** 备注 备注 **/
	private String remark;
	/** 标的总份数 标的总份数 **/
	private Long prdShare;
	/** 每份价格 每份价格 **/
	private BigDecimal sharePrice;
	/** 产品来源 1 合作方资产包、2 散标 **/
	private Integer prdSource;
	/** 是否可见 0 不可见、1 可见 **/
	private Integer visible;
	/** 可见终端 0 全部可见、1 仅PC端、2 仅移动端 **/
	private Integer visibleTerm;
	/** 标的介绍 标的介绍 **/
	private String introduction;
	/** 借款用途 借款用途 **/
	private String prdUse;
	/** 标的风险信息 标的风险信息 **/
	private String riskInfo;
	/** 保障方式 保障方式 **/
	private String safeguardDesc;
	/** 失败信息 第三方资金托管平台创建标的失败的信息 **/
	private String failedMsg;
	/** 创建人 创建人 **/
	private String createBy;
	/** 创建时间 创建时间 **/
	private String createTime;
	/** 修改人 修改人 **/
	private String modifyBy;
	/** 修改时间 修改时间 **/
	private String modifyTime;
	/** 是否支持体验金:0、不支持 1、支持 **/
	private Integer bonusType;
	/** 协议URL **/
	private String contractUrl;
	/** 投标范围 **/
	private String prdArea;
	/** 审核资料 **/
	private String verifyInfo;
	/** 计息方式：0 D(自然日)、1 T(工作日) **/
	private Integer valDelayType;
	/** 回款方式：0 D(自然日)、1 T(工作日) **/
	private Integer repDelayType;

	public String getPrdArea() {
		return prdArea;
	}

	public void setPrdArea(String prdArea) {
		this.prdArea = prdArea;
	}

	public Integer getPrdId() {
		return prdId;
	}

	public void setPrdId(Integer prdId) {
		this.prdId = prdId;
	}

	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	public Integer getAgrId() {
		return agrId;
	}

	public void setAgrId(Integer agrId) {
		this.agrId = agrId;
	}

	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getPrdAgrNum() {
		return prdAgrNum;
	}

	public void setPrdAgrNum(String prdAgrNum) {
		this.prdAgrNum = prdAgrNum;
	}

	public String getLoanTrdNum() {
		return loanTrdNum;
	}

	public void setLoanTrdNum(String loanTrdNum) {
		this.loanTrdNum = loanTrdNum;
	}

	public Integer getPrdNature() {
		return prdNature;
	}

	public void setPrdNature(Integer prdNature) {
		this.prdNature = prdNature;
	}

	public Integer getPrdActivity() {
		return prdActivity;
	}

	public void setPrdActivity(Integer prdActivity) {
		this.prdActivity = prdActivity;
	}

	public Integer getPrdType() {
		return prdType;
	}

	public void setPrdType(Integer prdType) {
		this.prdType = prdType;
	}

	public String getStrPrdAmount() {
		return prdAmount == null ? null : prdAmount.toPlainString();
	}

	public void setPrdAmount(BigDecimal prdAmount) {
		this.prdAmount = prdAmount;
	}

	public String getStrRepayedAmount() {
		return repayedAmount == null ? null : repayedAmount.toPlainString();
	}

	public void setRepayedAmount(BigDecimal repayedAmount) {
		this.repayedAmount = repayedAmount;
	}

	public String getStrRate() {
		return rate == null ? null : rate.toPlainString();
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getStrFloatingRate() {
		return floatingRate == null ? null : floatingRate.toPlainString();
	}

	public void setFloatingRate(BigDecimal floatingRate) {
		this.floatingRate = floatingRate;
	}

	public String getStrLoanRate() {
		return loanRate == null ? null : loanRate.toPlainString();
	}

	public void setLoanRate(BigDecimal loanRate) {
		this.loanRate = loanRate;
	}

	public Integer getPrdPeriod() {
		return prdPeriod;
	}

	public void setPrdPeriod(Integer prdPeriod) {
		this.prdPeriod = prdPeriod;
	}

	public Integer getPrdStage() {
		return prdStage;
	}

	public void setPrdStage(Integer prdStage) {
		this.prdStage = prdStage;
	}

	public String getPrdDate() {
		return prdDate;
	}

	public void setPrdDate(String prdDate) {
		this.prdDate = prdDate;
	}

	public String getColBeginDate() {
		return colBeginDate;
	}

	public void setColBeginDate(String colBeginDate) {
		this.colBeginDate = colBeginDate;
	}

	public String getColEndDate() {
		return colEndDate;
	}

	public void setColEndDate(String colEndDate) {
		this.colEndDate = colEndDate;
	}

	public String getColBeginTime() {
		return colBeginTime;
	}

	public void setColBeginTime(String colBeginTime) {
		this.colBeginTime = colBeginTime;
	}

	public String getColEndTime() {
		return colEndTime;
	}

	public void setColEndTime(String colEndTime) {
		this.colEndTime = colEndTime;
	}

	public String getColFinishDate() {
		return colFinishDate;
	}

	public void setColFinishDate(String colFinishDate) {
		this.colFinishDate = colFinishDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public Integer getValDelayDays() {
		return valDelayDays;
	}

	public void setValDelayDays(Integer valDelayDays) {
		this.valDelayDays = valDelayDays;
	}

	public String getRepDate() {
		return repDate;
	}

	public void setRepDate(String repDate) {
		this.repDate = repDate;
	}

	public Integer getRepDelayDays() {
		return repDelayDays;
	}

	public void setRepDelayDays(Integer repDelayDays) {
		this.repDelayDays = repDelayDays;
	}

	public Integer getRepType() {
		return repType;
	}

	public void setRepType(Integer repType) {
		this.repType = repType;
	}

	public Integer getRepDay() {
		return repDay;
	}

	public void setRepDay(Integer repDay) {
		this.repDay = repDay;
	}

	public String getStrSecurityDeposit() {
		return securityDeposit == null ? null : securityDeposit.toPlainString();
	}

	public void setSecurityDeposit(BigDecimal securityDeposit) {
		this.securityDeposit = securityDeposit;
	}

	public String getStrInvFeePercent() {
		return invFeePercent == null ? null : invFeePercent.toPlainString();
	}

	public void setInvFeePercent(BigDecimal invFeePercent) {
		this.invFeePercent = invFeePercent;
	}

	public Integer getInvFeeType() {
		return invFeeType;
	}

	public void setInvFeeType(Integer invFeeType) {
		this.invFeeType = invFeeType;
	}

	public String getStrBorFeePercent() {
		return borFeePercent == null ? null : borFeePercent.toPlainString();
	}

	public void setBorFeePercent(BigDecimal borFeePercent) {
		this.borFeePercent = borFeePercent;
	}

	public Integer getBorFeeType() {
		return borFeeType;
	}

	public void setBorFeeType(Integer borFeeType) {
		this.borFeeType = borFeeType;
	}

	public String getStrLateFeePercent() {
		return lateFeePercent == null ? null : lateFeePercent.toPlainString();
	}

	public void setLateFeePercent(BigDecimal lateFeePercent) {
		this.lateFeePercent = lateFeePercent;
	}

	public String getStrMinInvAmt() {
		return minInvAmt == null ? null : minInvAmt.toPlainString();
	}

	public void setMinInvAmt(BigDecimal minInvAmt) {
		this.minInvAmt = minInvAmt;
	}

	public String getStrMinRseAmt() {
		return minRseAmt == null ? null : minRseAmt.toPlainString();
	}

	public void setMinRseAmt(BigDecimal minRseAmt) {
		this.minRseAmt = minRseAmt;
	}

	public String getStrMaxInvAmt() {
		return maxInvAmt == null ? null : maxInvAmt.toPlainString();
	}

	public void setMaxInvAmt(BigDecimal maxInvAmt) {
		this.maxInvAmt = maxInvAmt;
	}

	public Integer getIsRecommended() {
		return isRecommended;
	}

	public void setIsRecommended(Integer isRecommended) {
		this.isRecommended = isRecommended;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getPrdShare() {
		return prdShare;
	}

	public void setPrdShare(Long prdShare) {
		this.prdShare = prdShare;
	}

	public String getStrSharePrice() {
		return sharePrice == null ? null : sharePrice.toPlainString();
	}

	public void setSharePrice(BigDecimal sharePrice) {
		this.sharePrice = sharePrice;
	}

	public Integer getPrdSource() {
		return prdSource;
	}

	public void setPrdSource(Integer prdSource) {
		this.prdSource = prdSource;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	public Integer getVisibleTerm() {
		return visibleTerm;
	}

	public void setVisibleTerm(Integer visibleTerm) {
		this.visibleTerm = visibleTerm;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getPrdUse() {
		return prdUse;
	}

	public void setPrdUse(String prdUse) {
		this.prdUse = prdUse;
	}

	public String getRiskInfo() {
		return riskInfo;
	}

	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public String getSafeguardDesc() {
		return safeguardDesc;
	}

	public void setSafeguardDesc(String safeguardDesc) {
		this.safeguardDesc = safeguardDesc;
	}

	public String getFailedMsg() {
		return failedMsg;
	}

	public void setFailedMsg(String failedMsg) {
		this.failedMsg = failedMsg;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getBonusType() {
		return bonusType;
	}

	public void setBonusType(Integer bonusType) {
		this.bonusType = bonusType;
	}

	public String getContractUrl() {
		return contractUrl;
	}

	public void setContractUrl(String contractUrl) {
		this.contractUrl = contractUrl;
	}

	public BigDecimal getPrdAmount() {
		return prdAmount;
	}

	public BigDecimal getRepayedAmount() {
		return repayedAmount;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public BigDecimal getFloatingRate() {
		return floatingRate;
	}

	public BigDecimal getLoanRate() {
		return loanRate;
	}

	public BigDecimal getSecurityDeposit() {
		return securityDeposit;
	}

	public BigDecimal getInvFeePercent() {
		return invFeePercent;
	}

	public BigDecimal getBorFeePercent() {
		return borFeePercent;
	}

	public BigDecimal getLateFeePercent() {
		return lateFeePercent;
	}

	public BigDecimal getMinInvAmt() {
		return minInvAmt;
	}

	public BigDecimal getMinRseAmt() {
		return minRseAmt;
	}

	public BigDecimal getMaxInvAmt() {
		return maxInvAmt;
	}

	public BigDecimal getSharePrice() {
		return sharePrice;
	}

	public BigDecimal getDefaultRate() {
		return defaultRate;
	}

	public void setDefaultRate(BigDecimal defaultRate) {
		this.defaultRate = defaultRate;
	}

	public BigDecimal getRewardRate() {
		return rewardRate;
	}

	public void setRewardRate(BigDecimal rewardRate) {
		this.rewardRate = rewardRate;
	}

	public String getVerifyInfo() {
		return verifyInfo;
	}

	public void setVerifyInfo(String verifyInfo) {
		this.verifyInfo = verifyInfo;
	}

	public Integer getValDelayType() {
		return valDelayType;
	}

	public void setValDelayType(Integer valDelayType) {
		this.valDelayType = valDelayType;
	}

	public Integer getRepDelayType() {
		return repDelayType;
	}

	public void setRepDelayType(Integer repDelayType) {
		this.repDelayType = repDelayType;
	}

}
