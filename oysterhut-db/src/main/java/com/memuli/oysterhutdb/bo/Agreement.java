package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class Agreement extends BaseEntity {

	private static final long serialVersionUID = -7806037198248938579L;
	/** 协议ID **/
	private Integer agrId;
	/** 协议模型内容 **/
	private String agrTempContent;
	/** 协议内容 **/
	private String agrContent;
	/** 协议名称 **/
	private String agrName;
	/** 状态 **/
	private String status;
	/** 创建人 **/
	private String createBy;
	/** 创建时间 **/
	private String createTime;
	/** 修改人 **/
	private String modifyBy;
	/** 修改时间 **/
	private String modifyTime;
	/** 备注 **/
	private String remark;
	/** 水印图片地址 **/
	private String waterMarkSrc;
	/** 协议地址 **/
	private String agrPath;

	public Integer getAgrId() {
		return agrId;
	}

	public void setAgrId(Integer agrId) {
		this.agrId = agrId;
	}

	public String getAgrTempContent() {
		return agrTempContent;
	}

	public void setAgrTempContent(String agrTempContent) {
		this.agrTempContent = agrTempContent;
	}

	public String getAgrContent() {
		return agrContent;
	}

	public void setAgrContent(String agrContent) {
		this.agrContent = agrContent;
	}

	public String getAgrName() {
		return agrName;
	}

	public void setAgrName(String agrName) {
		this.agrName = agrName;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWaterMarkSrc() {
		return waterMarkSrc;
	}

	public void setWaterMarkSrc(String waterMarkSrc) {
		this.waterMarkSrc = waterMarkSrc;
	}

	public String getAgrPath() {
		return agrPath;
	}
	public void setAgrPath(String agrPath) {
		this.agrPath = agrPath;
	}
}
