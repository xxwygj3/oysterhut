package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

public class AccTrade extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 自增长ID 自增长ID **/
	private Integer trdId;
	/** 交易CODE 交易CODE：充值DP、提现ST **/
	private String trdCode;
	/** 交易币种 交易币种 **/
	private String crCode;
	/** 二级交易账号 二级交易账号 **/
	private String accCode;
	/** 客户号 客户号 **/
	private String cusCode;
	/** 交易流水号 交易流水号 **/
	private String trdNum;
	/** 银行网关流水号 **/
	private String chlTrdNum;
	/** 账户网关流水号 **/
	private String accTrdNum;
	/** 账户状态 **/
	private Integer accTrdStatus;
	/** 记账时间 **/
	private String accTrdTime;
	/** 交易金额 交易金额 **/
	private BigDecimal trdAmount;
	/** 交易手续费 交易手续费 **/
	private BigDecimal trdFee;
	/** 手续费承担方 手续费承担方 0#用户 1#平台 **/
	private Integer feeFrom;
	/** 交易状态 交易状态 0#初始化交易 1#交易成功 9#交易失败 **/
	private String trdStatus;
	/** 预交易时间 预交易时间 **/
	private String preTime;
	/** 完成交易时间 完成交易时间 **/
	private String endTime;
	/** 交易备注 交易备注 **/
	private String trdMemo;
	/** 错误信息 错误信息 **/
	private String failedMsg;
	/** 银行编号 **/
	private String trdBank;
	/** 客户类型 0#个人 1#商户 **/
	private Integer cusType;
	/** 客户类型 1#个投资人 1#借款人 **/
	private Integer cusBiz;
	/** 完成交易记账流水号 **/
	private String eAccTrdNum;
	/** 完成交易记账状态 **/
	private Integer eAccTrdStatus;
	/** 完成交易记账完成时间 **/
	private String eAccTrdTime;
	/** 用户名 **/
	private String usrName;
	/** 银行卡号 **/
	private String cardNum;
	/** 充值类型 1 快捷充值 0 网银充值 **/
	private String payType;
	/** 开户行名称 **/
	private String branchName;
	/** 银行卡手机预留号 **/
	private String mobile;
	/** 手机验证码 **/
	private String validateCode;
	/** 备用字段 **/
	private String remark;
	/** 渠道来源**/
	private Integer srcNo;
	/** 是否是移动端(IOS或Android) **/
	private Boolean isApp;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String geteAccTrdNum() {
		return eAccTrdNum;
	}

	public void seteAccTrdNum(String eAccTrdNum) {
		this.eAccTrdNum = eAccTrdNum;
	}

	public Integer geteAccTrdStatus() {
		return eAccTrdStatus;
	}

	public void seteAccTrdStatus(Integer eAccTrdStatus) {
		this.eAccTrdStatus = eAccTrdStatus;
	}

	public String geteAccTrdTime() {
		return eAccTrdTime;
	}

	public void seteAccTrdTime(String eAccTrdTime) {
		this.eAccTrdTime = eAccTrdTime;
	}

	public Integer getCusType() {
		return cusType;
	}

	public void setCusType(Integer cusType) {
		this.cusType = cusType;
	}

	public Integer getCusBiz() {
		return cusBiz;
	}

	public void setCusBiz(Integer cusBiz) {
		this.cusBiz = cusBiz;
	}

	public AccTrade() {
		this.trdMemo = "";
		this.chlTrdNum = "";
		this.accTrdNum = "";
		this.endTime = "";
		this.trdFee = BigDecimal.ZERO;
	}

	public String getFailedMsg() {
		return failedMsg;
	}

	public void setFailedMsg(String failedMsg) {
		this.failedMsg = failedMsg;
	}

	public String getTrdBank() {
		return trdBank;
	}

	public void setTrdBank(String trdBank) {
		this.trdBank = trdBank;
	}

	// 自增长ID 自增长ID
	public Integer getTrdId() {
		return trdId;
	}

	public void setTrdId(Integer value) {
		this.trdId = value;
	}

	// 交易CODE 交易CODE：充值DP、提现ST
	public String getTrdCode() {
		return trdCode;
	}

	public void setTrdCode(String value) {
		this.trdCode = value;
	}

	// 交易币种 交易币种
	public String getCrCode() {
		return crCode;
	}

	public void setCrCode(String value) {
		this.crCode = value;
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

	// 交易金额 交易金额
	public String getStrTrdAmount() {
		return trdAmount==null?null:trdAmount.toPlainString();
	}

	public void setTrdAmount(BigDecimal value) {
		this.trdAmount = value;
	}

	// 交易手续费 交易手续费
	public String getStrTrdFee() {
		return trdFee==null?null:trdFee.toPlainString();
	}

	public void setTrdFee(BigDecimal value) {
		this.trdFee = value;
	}

	// 手续费承担方 手续费承担方 0#用户 1#平台
	public Integer getFeeFrom() {
		return feeFrom;
	}

	public void setFeeFrom(Integer value) {
		this.feeFrom = value;
	}

	// 交易状态 交易状态 0#初始化交易 1#交易成功 9#交易失败
	public String getTrdStatus() {
		return trdStatus;
	}

	public void setTrdStatus(String value) {
		this.trdStatus = value;
	}

	// 预交易时间 预交易时间
	public String getPreTime() {
		return preTime;
	}

	public void setPreTime(String value) {
		this.preTime = value;
	}

	// 完成交易时间 完成交易时间
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String value) {
		this.endTime = value;
	}

	// 交易备注 交易备注
	public String getTrdMemo() {
		return trdMemo;
	}

	public void setTrdMemo(String value) {
		this.trdMemo = value;
	}

	public String getAccTrdTime() {
		return accTrdTime;
	}

	public void setAccTrdTime(String accTrdTime) {
		this.accTrdTime = accTrdTime;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Integer getSrcNo() {
		return srcNo;
	}

	public void setSrcNo(Integer srcNo) {
		this.srcNo = srcNo;
	}

	public BigDecimal getTrdAmount() {
		return trdAmount;
	}

	public BigDecimal getTrdFee() {
		return trdFee;
	}

	public Boolean getIsApp() {
		return isApp;
	}

	public void setIsApp(Boolean isApp) {
		this.isApp = isApp;
	}
}
