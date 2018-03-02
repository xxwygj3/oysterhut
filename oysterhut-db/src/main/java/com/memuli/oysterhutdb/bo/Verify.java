package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/* 标的审核操作 标的审核操作 */
public class Verify extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 审核ID 自增长 **/
	private Integer vrfId;
	/** 产品编号 **/
	private String prdCode;
	/** 产品名称 **/
	private String prdName;
	/** 审核类型 1#标的发布 2#标的放款 3#标的结束 4#流标 **/
	private Integer vrfType;
	/** 审核状态 0#待审核 1#审核通过 2#审核拒绝 **/
	private String vrfStatus;
	/** 申请人 **/
	private String appBy;
	/** 申请时间 **/
	private String appTime;
	/** 申请备注 **/
	private String appMemo;
	/** 审核人 **/
	private String vrfBy;
	/** 审核时间 **/
	private String vrfTime;
	/** 审核理由 **/
	private String vrfReason;

	public Integer getVrfId() {
		return vrfId;
	}

	public void setVrfId(Integer vrfId) {
		this.vrfId = vrfId;
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

	public Integer getVrfType() {
		return vrfType;
	}

	public void setVrfType(Integer vrfType) {
		this.vrfType = vrfType;
	}

	public String getVrfStatus() {
		return vrfStatus;
	}

	public void setVrfStatus(String vrfStatus) {
		this.vrfStatus = vrfStatus;
	}

	public String getAppBy() {
		return appBy;
	}

	public void setAppBy(String appBy) {
		this.appBy = appBy;
	}

	public String getAppTime() {
		return appTime;
	}

	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	public String getAppMemo() {
		return appMemo;
	}

	public void setAppMemo(String appMemo) {
		this.appMemo = appMemo;
	}

	public String getVrfBy() {
		return vrfBy;
	}

	public void setVrfBy(String vrfBy) {
		this.vrfBy = vrfBy;
	}

	public String getVrfTime() {
		return vrfTime;
	}

	public void setVrfTime(String vrfTime) {
		this.vrfTime = vrfTime;
	}

	public String getVrfReason() {
		return vrfReason;
	}

	public void setVrfReason(String vrfReason) {
		this.vrfReason = vrfReason;
	}
}
