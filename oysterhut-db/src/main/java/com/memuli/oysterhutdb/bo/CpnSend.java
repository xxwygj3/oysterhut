package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.math.BigDecimal;

/* 优惠券发送信息 */

public class CpnSend extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    /** 发放优惠券id**/
    private Integer sendId;
    /** 优惠券分发编号**/
    private String sendCode;
    /** 优惠券编号**/
    private String  cpnCode;
    /** 优惠劵状态**/
    private String status;
    /** 优惠劵创建人**/
    private String createBy;
    /** 优惠劵分发时间  yyyy-mm-dd hh24:mi:ss**/
    private String sendTime;
    /** 发放范围 1所有用户、2特定用户 **/
    private String sendRange;
    /**是否实名  0否、1是*/
    private Integer sendTpStatus;
    /**分发优惠券的性别 1男、2女*/
    private Integer sendGender;
    /** 生日 MM-DD **/
    private String sendBirthday;
    /**分发优惠券开始年龄*/
    private Integer sendAgeStart;
    /**分发优惠券最大年龄*/
    private Integer sendAgeEnd;
    /** 所在地省 **/
    private String sendProvince;
    /** 所在地市 **/
    private String sendCity;
    /**是否绑卡  0否、1是*/
    private Integer sendBankcardStatus;
    /**是否已投资  0否、1是*/
    private Integer sendInvestmentStatus;
    /**累计投资大于*/
    private BigDecimal sendThanStsInvestment;
    /** 发放说明 **/
    private String sendDesc;
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public String getSendCode() {
		return sendCode;
	}
	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}
	public String getCpnCode() {
		return cpnCode;
	}
	public void setCpnCode(String cpnCode) {
		this.cpnCode = cpnCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getSendRange() {
		return sendRange;
	}
	public void setSendRange(String sendRange) {
		this.sendRange = sendRange;
	}
	public Integer getSendTpStatus() {
		return sendTpStatus;
	}
	public void setSendTpStatus(Integer sendTpStatus) {
		this.sendTpStatus = sendTpStatus;
	}
	public Integer getSendGender() {
		return sendGender;
	}
	public void setSendGender(Integer sendGender) {
		this.sendGender = sendGender;
	}
	public String getSendBirthday() {
		return sendBirthday;
	}
	public void setSendBirthday(String sendBirthday) {
		this.sendBirthday = sendBirthday;
	}
	public Integer getSendAgeStart() {
		return sendAgeStart;
	}
	public void setSendAgeStart(Integer sendAgeStart) {
		this.sendAgeStart = sendAgeStart;
	}
	public Integer getSendAgeEnd() {
		return sendAgeEnd;
	}
	public void setSendAgeEnd(Integer sendAgeEnd) {
		this.sendAgeEnd = sendAgeEnd;
	}
	public String getSendProvince() {
		return sendProvince;
	}
	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}
	public String getSendCity() {
		return sendCity;
	}
	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}
	public Integer getSendBankcardStatus() {
		return sendBankcardStatus;
	}
	public void setSendBankcardStatus(Integer sendBankcardStatus) {
		this.sendBankcardStatus = sendBankcardStatus;
	}
	public Integer getSendInvestmentStatus() {
		return sendInvestmentStatus;
	}
	public void setSendInvestmentStatus(Integer sendInvestmentStatus) {
		this.sendInvestmentStatus = sendInvestmentStatus;
	}
	public BigDecimal getSendThanStsInvestment() {
		return sendThanStsInvestment;
	}
	public void setSendThanStsInvestment(BigDecimal sendThanStsInvestment) {
		this.sendThanStsInvestment = sendThanStsInvestment;
	}
	public String getSendDesc() {
		return sendDesc;
	}
	public void setSendDesc(String sendDesc) {
		this.sendDesc = sendDesc;
	}
    
  

}
