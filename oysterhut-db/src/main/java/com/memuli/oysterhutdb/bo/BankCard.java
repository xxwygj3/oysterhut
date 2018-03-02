package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/* 客户银行卡表 */
public class BankCard extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 银行卡ID **/
	private Integer cardId;
	/** 开户银行名称 **/
	private String bankName;
	/** 银行账号 **/
	private String cardNum;
	/** 开户银行户名 **/
	private String bankAccName;
	/** 客户编号 关联客户编号 **/
	private String cusCode;
	/** 是否默认 0 否、1 是 **/
	private Integer isDefault;
	/** 状态 **/
	private String status;
	/** 银行号 **/
	private String bankCode;
	/** 网关交易流水号 **/
	private String chlTrdNum;
	/** 绑卡流水号 **/
	private String trdNum;
	/** 预交易时间 **/
	private String preTime;
	/** 完成交易时间 **/
	private String endTime;
	/** 解绑时间 **/
	private String unbindTime;
	/** 失败信息 **/
	private String failedMsg;
	/** 省份编号 **/
	private String provinceCode;
	/** 城市编号 **/
	private String cityCode;
	/** 支行名称 **/
	private String branchName;
	/** 是否支持代扣 0:不支持 1:支持 **/
	private String isQkPay;
	/** 换绑来源**/
	private String changeSource;	
	/** 换绑原因**/
	private String changeMessage;
	/** 银行卡手机预留号**/
	private String mobile;
	/** 手机验证码**/
	private String validateCode;
	/** 渠道来源**/
	private Integer srcNo;

	public String getChlTrdNum() {
		return chlTrdNum;
	}

	public void setChlTrdNum(String chlTrdNum) {
		this.chlTrdNum = chlTrdNum;
	}

	public String getTrdNum() {
		return trdNum;
	}

	public void setTrdNum(String trdNum) {
		this.trdNum = trdNum;
	}

	public String getPreTime() {
		return preTime;
	}

	public void setPreTime(String preTime) {
		this.preTime = preTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFailedMsg() {
		return failedMsg;
	}

	public void setFailedMsg(String failedMsg) {
		this.failedMsg = failedMsg;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public BankCard() {
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getBankAccName() {
		return bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIsQkPay() {
		return isQkPay;
	}

	public void setIsQkPay(String isQkPay) {
		this.isQkPay = isQkPay;
	}

	public String getChangeSource() {
		return changeSource;
	}

	public void setChangeSource(String changeSource) {
		this.changeSource = changeSource;
	}

	public String getChangeMessage() {
		return changeMessage;
	}

	public void setChangeMessage(String changeMessage) {
		this.changeMessage = changeMessage;
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

	public String getUnbindTime() {
		return unbindTime;
	}

	public void setUnbindTime(String unbindTime) {
		this.unbindTime = unbindTime;
	}

	public Integer getSrcNo() {
		return srcNo;
	}

	public void setSrcNo(Integer srcNo) {
		this.srcNo = srcNo;
	}
	
}
