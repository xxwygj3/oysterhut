package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/* 消息通知表 */
public class Notice extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 消息ID **/
	private Integer ntcId;
	/** 消息标题 **/
	private String ntcTitle;
	/** 消息内容 **/
	private String ntcContent;
	/** 通知接受对象 关联客户表 **/
	private String cusCode;
	/** 是否已读 0 未读、1 已读 **/
	private Integer isViewed;
	/** 状态 0 无效、1 有效 **/
	private String status;
	/** 通知时间 **/
	private String ntcTime;

	public Notice() {
	}

	public Integer getNtcId() {
		return ntcId;
	}

	public void setNtcId(Integer ntcId) {
		this.ntcId = ntcId;
	}

	public String getNtcTitle() {
		return ntcTitle;
	}

	public void setNtcTitle(String ntcTitle) {
		this.ntcTitle = ntcTitle;
	}

	public String getNtcContent() {
		return ntcContent;
	}

	public void setNtcContent(String ntcContent) {
		this.ntcContent = ntcContent;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public Integer getIsViewed() {
		return isViewed;
	}

	public void setIsViewed(Integer isViewed) {
		this.isViewed = isViewed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNtcTime() {
		return ntcTime;
	}

	public void setNtcTime(String ntcTime) {
		this.ntcTime = ntcTime;
	}
}
