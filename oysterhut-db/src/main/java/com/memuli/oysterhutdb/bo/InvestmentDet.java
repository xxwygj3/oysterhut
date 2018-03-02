package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

/* 投资交易明细 投资交易明细 */
public class InvestmentDet extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 交易ID 交易ID **/
	private Integer trdId;
	/** 交易流水号 交易流水号 **/
	private String trdNum;
	/** 投资汇总表订单号 **/
	private String inTrdNum;
	/** 银行网关流水号 **/
	private String chlTrdNum;
	/** 账户网关流水号 **/
	private String accTrdNum;
	/** 账户状态 **/
	private Integer accTrdStatus;
	/** 记账时间 **/
	private String accTrdTime;
	/** 二级交易账号 二级交易账号 **/
	private String accCode;
	/** 客户号 投资人客户号 **/
	private String cusCode;
	/** 客户类型 **/
	private Integer cusType;
	/** 标的编号 标的编号 **/
	private String prdCode;
	/** 投资金额 投资金额 **/
	private BigDecimal trdAmount;
	/** 红包支付金额 红包支付金额 **/
	private BigDecimal dedAmount;
	/** 投资手续费 投资手续费 **/
	private BigDecimal trdFee;
	/** 投资方式 1 手动投标、2 自动投标 **/
	private Integer invType;
	/** 投资日期 yyyy-mm-dd **/
	private String trdDate;
	/** 投资时间 投资时间 **/
	private String preTime;
	/** 交易完成时间 交易完成时间 **/
	private String endTime;
	/** 状态 0 交易处理中、1 交易成功、2 交易失败 **/
	private String status;
	/** 失败信息 失败信息 **/
	private String failedMsg;
	/** 备注 备注 **/
	private String remark;
	/** 标的名称 **/
	private String prdName;
	/** 交易年份 **/
	private String recordYear;
	/** 交易月份 **/
	private String recordMonth;
	/** 投资扩展域 **/
	private String inProps;
	/** 渠道来源**/
	private Integer srcNo;
	/** 交易状态 **/
	private String trdStatus;
	/** 优惠券流水号 **/
	private String cpnNum;
	/** 尊享码 **/
	private String vipCode;

	public InvestmentDet() {

	}

	// 交易ID 交易ID
	public Integer getTrdId() {
		return trdId;
	}

	public String getRecordYear() {
		return recordYear;
	}

	public void setRecordYear(String recordYear) {
		this.recordYear = recordYear;
	}

	public String getRecordMonth() {
		return recordMonth;
	}

	public void setRecordMonth(String recordMonth) {
		this.recordMonth = recordMonth;
	}

	public void setTrdId(Integer value) {
		this.trdId = value;
	}

	// 交易流水号 交易流水号
	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String value) {
		this.trdNum = value;
	}

	public String getChlTrdNum() {
		return chlTrdNum;
	}

	public void setChlTrdNum(String chlTrdNum) {
		this.chlTrdNum = chlTrdNum;
	}

	public String getAccTrdNum() {
		return accTrdNum;
	}

	public void setAccTrdNum(String accTrdNum) {
		this.accTrdNum = accTrdNum;
	}

	public Integer getAccTrdStatus() {
		return accTrdStatus;
	}

	public void setAccTrdStatus(Integer accTrdStatus) {
		this.accTrdStatus = accTrdStatus;
	}

	// 二级交易账号 二级交易账号
	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String value) {
		this.accCode = value;
	}

	// 客户号 投资人客户号
	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String value) {
		this.cusCode = value;
	}

	// 标的编号 标的编号
	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String value) {
		this.prdCode = value;
	}

	// 投资金额 投资金额
	public String getStrTrdAmount() {
		return trdAmount==null?null:trdAmount.toPlainString();
	}

	public void setTrdAmount(BigDecimal value) {
		this.trdAmount = value;
	}

	// 红包支付金额 红包支付金额
	public String getStrDedAmount() {
		return dedAmount==null?null:dedAmount.toPlainString();
	}

	public void setDedAmount(BigDecimal value) {
		this.dedAmount = value;
	}

	// 投资手续费 投资手续费
	public String getStrTrdFee() {
		return trdFee==null?null:trdFee.toPlainString();
	}

	public void setTrdFee(BigDecimal value) {
		this.trdFee = value;
	}

	// 投资方式 1 手动投标、2 自动投标
	public Integer getInvType() {
		return invType;
	}

	public void setInvType(Integer value) {
		this.invType = value;
	}

	public String getInTrdNum() {
		return inTrdNum;
	}

	public void setInTrdNum(String inTrdNum) {
		this.inTrdNum = inTrdNum;
	}

	// 投资日期 yyyy-mm-dd
	public String getTrdDate() {
		return trdDate;
	}

	public void setTrdDate(String value) {
		this.trdDate = value;
	}

	// 投资时间 投资时间
	public String getPreTime() {
		return preTime;
	}

	public void setPreTime(String value) {
		this.preTime = value;
	}

	// 交易完成时间 交易完成时间
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String value) {
		this.endTime = value;
	}

	// 状态 0 交易处理中、1 交易成功、2 交易失败
	public String getStatus() {
		return status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	// 失败信息 失败信息
	public String getFailedMsg() {
		return failedMsg;
	}

	public void setFailedMsg(String value) {
		this.failedMsg = value;
	}

	// 备注 备注
	public String getRemark() {
		return remark;
	}

	public void setRemark(String value) {
		this.remark = value;
	}

	public Integer getCusType() {
		return cusType;
	}

	public void setCusType(Integer cusType) {
		this.cusType = cusType;
	}

	public String getAccTrdTime() {
		return accTrdTime;
	}

	public void setAccTrdTime(String accTrdTime) {
		this.accTrdTime = accTrdTime;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getInProps() {
		return inProps;
	}

	public void setInProps(String inProps) {
		this.inProps = inProps;
	}

	public Integer getSrcNo() {
		return srcNo;
	}

	public void setSrcNo(Integer srcNo) {
		this.srcNo = srcNo;
	}

	public String getTrdStatus() {
		return trdStatus;
	}

	public void setTrdStatus(String trdStatus) {
		this.trdStatus = trdStatus;
	}

	public BigDecimal getTrdAmount() {
		return trdAmount;
	}

	public BigDecimal getDedAmount() {
		return dedAmount;
	}

	public BigDecimal getTrdFee() {
		return trdFee;
	}

	public String getCpnNum() {
		return cpnNum;
	}

	public void setCpnNum(String cpnNum) {
		this.cpnNum = cpnNum;
	}

	public String getVipCode() {
		return vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}
	
}
