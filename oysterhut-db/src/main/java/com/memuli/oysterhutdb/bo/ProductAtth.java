package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

public class ProductAtth extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/* 附加信息编号 */
	private Integer atthId;
	/* 产品编号 */
	private String prdCode;
	/* 抵押物 */
	private String collateral;
	/* 抵押物估值 */
	private BigDecimal colVal;
	/* 抵押物描述 */
	private String colDesc;
	/* 借款人姓名 */
	private String borName;
	/* 借款人年龄 */
	private Integer borAge;
	/* 借款人婚姻状况 */
	private Integer borMaritalStatus;
	/* 借款人性别 */
	private Integer borGender;
	/* 借款人工作地点 */
	private String borJobsite;
	/* 借款人职位 */
	private String borPosition;
	/* 借款人公司规模 */
	private String borCorporateSize;
	/* 借款人所处行业 */
	private String borIndustry;
	/* 借款人月收入 */
	private BigDecimal borIncome;
	/* 借款人工作年限 */
	private Integer borWorkingMonths;
	/* 身份证复印件 */
	private String idFile;
	/* 抵押物复印件 */
	private String colFile;
	/* 财力证明复印件 */
	private String capFile;
	/* 工作证明复印件 */
	private String jobFile;
	/* 信用证明复印件 */
	private String creditFile;
	/* 借款人类型 */
	private String borType;
	/* 公司名称 */
	private String borBizCompany;
	/* 城市 */
	private String borBizCity;
	/* 公司行业 */
	private String borBizArea;
	/* 公司规模 */
	private String borBizSize;
	/* 年销售额 */
	private String borBizAmount;
	/* 公司介绍 */
	private String borBizIntroduction;
	/* 认证文件 */
	private String borBizCertFile;
	/* 合同名称 */
	private String agrName;
	/** 学历 **/
	private String borEducation;
	/** 籍贯 **/
	private String borOrigin;
	/** 证明材料 **/
	private String certifyInfo;

	public String getBorType() {
		return borType;
	}

	public void setBorType(String borType) {
		this.borType = borType;
	}

	public String getBorBizCompany() {
		return borBizCompany;
	}

	public void setBorBizCompany(String borBizCompany) {
		this.borBizCompany = borBizCompany;
	}

	public String getBorBizCity() {
		return borBizCity;
	}

	public void setBorBizCity(String borBizCity) {
		this.borBizCity = borBizCity;
	}

	public String getBorBizArea() {
		return borBizArea;
	}

	public void setBorBizArea(String borBizArea) {
		this.borBizArea = borBizArea;
	}

	public String getBorBizSize() {
		return borBizSize;
	}

	public void setBorBizSize(String borBizSize) {
		this.borBizSize = borBizSize;
	}

	public String getBorBizAmount() {
		return borBizAmount;
	}

	public void setBorBizAmount(String borBizAmount) {
		this.borBizAmount = borBizAmount;
	}

	public String getBorBizIntroduction() {
		return borBizIntroduction;
	}

	public void setBorBizIntroduction(String borBizIntroduction) {
		this.borBizIntroduction = borBizIntroduction;
	}

	public String getBorBizCertFile() {
		return borBizCertFile;
	}

	public void setBorBizCertFile(String borBizCertFile) {
		this.borBizCertFile = borBizCertFile;
	}

	public String getAgrName() {
		return agrName;
	}

	public void setAgrName(String agrName) {
		this.agrName = agrName;
	}

	public Integer getBorWorkingMonths() {
		return borWorkingMonths;
	}

	public void setBorWorkingMonths(Integer borWorkingMonths) {
		this.borWorkingMonths = borWorkingMonths;
	}

	public String getJobFile() {
		return jobFile;
	}

	public void setJobFile(String jobFile) {
		this.jobFile = jobFile;
	}

	public String getCreditFile() {
		return creditFile;
	}

	public void setCreditFile(String creditFile) {
		this.creditFile = creditFile;
	}

	public Integer getAtthId() {
		return atthId;
	}

	public void setAtthId(Integer atthId) {
		this.atthId = atthId;
	}

	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}

	public String getCollateral() {
		return collateral;
	}

	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}

	public BigDecimal getColVal() {
		return colVal;
	}

	public void setColVal(BigDecimal colVal) {
		this.colVal = colVal;
	}

	public String getColDesc() {
		return colDesc;
	}

	public void setColDesc(String colDesc) {
		this.colDesc = colDesc;
	}

	public String getBorName() {
		return borName;
	}

	public void setBorName(String borName) {
		this.borName = borName;
	}

	public Integer getBorAge() {
		return borAge;
	}

	public void setBorAge(Integer borAge) {
		this.borAge = borAge;
	}

	public Integer getBorMaritalStatus() {
		return borMaritalStatus;
	}

	public void setBorMaritalStatus(Integer borMaritalStatus) {
		this.borMaritalStatus = borMaritalStatus;
	}

	public Integer getBorGender() {
		return borGender;
	}

	public void setBorGender(Integer borGender) {
		this.borGender = borGender;
	}

	public String getBorJobsite() {
		return borJobsite;
	}

	public void setBorJobsite(String borJobsite) {
		this.borJobsite = borJobsite;
	}

	public String getBorPosition() {
		return borPosition;
	}

	public void setBorPosition(String borPosition) {
		this.borPosition = borPosition;
	}

	public String getBorCorporateSize() {
		return borCorporateSize;
	}

	public void setBorCorporateSize(String borCorporateSize) {
		this.borCorporateSize = borCorporateSize;
	}

	public String getBorIndustry() {
		return borIndustry;
	}

	public void setBorIndustry(String borIndustry) {
		this.borIndustry = borIndustry;
	}

	public BigDecimal getBorIncome() {
		return borIncome;
	}

	public void setBorIncome(BigDecimal borIncome) {
		this.borIncome = borIncome;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	public String getColFile() {
		return colFile;
	}

	public void setColFile(String colFile) {
		this.colFile = colFile;
	}

	public String getCapFile() {
		return capFile;
	}

	public void setCapFile(String capFile) {
		this.capFile = capFile;
	}

	public String getBorEducation() {
		return borEducation;
	}

	public void setBorEducation(String borEducation) {
		this.borEducation = borEducation;
	}

	public String getBorOrigin() {
		return borOrigin;
	}

	public void setBorOrigin(String borOrigin) {
		this.borOrigin = borOrigin;
	}

	public String getCertifyInfo() {
		return certifyInfo;
	}

	public void setCertifyInfo(String certifyInfo) {
		this.certifyInfo = certifyInfo;
	}

}
