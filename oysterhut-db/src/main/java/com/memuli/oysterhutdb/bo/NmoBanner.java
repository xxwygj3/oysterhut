package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class NmoBanner extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/** Banner编号 **/
	private Integer bannId;
	/** Banner名称 **/
	private String bannName;
	/** Banner图片uri **/
	private String bannUri;
	/** Banner链接地址 **/
	private String bannLink;
	/** Banner排序 **/
	private Integer bannOrder;
	/** 状态 0 无效、1 有效 **/
	private Integer status;
	/** 创建人 **/
	private String createBy;
	/** 创建时间 yyyy-mm-dd hh24:mi:ss **/
	private String createTime;
	/** 修改人 **/
	private String modifyBy;
	/** 修改时间 yyyy-mm-dd hh24:mi:ss **/
	private String modifyTime;

	public Integer getBannId() {
		return bannId;
	}

	public void setBannId(Integer bannId) {
		this.bannId = bannId;
	}

	public String getBannName() {
		return bannName;
	}

	public void setBannName(String bannName) {
		this.bannName = bannName;
	}

	public String getBannUri() {
		return bannUri;
	}

	public void setBannUri(String bannUri) {
		this.bannUri = bannUri;
	}

	public String getBannLink() {
		return bannLink;
	}

	public void setBannLink(String bannLink) {
		this.bannLink = bannLink;
	}

	public Integer getBannOrder() {
		return bannOrder;
	}

	public void setBannOrder(Integer bannOrder) {
		this.bannOrder = bannOrder;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

}
