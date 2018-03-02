package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/* 系统资源表 */
public class Resource extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/** 资源ID **/
	private Integer resId;
	/** 资源名称 **/
	private String resName;
	/** 父资源ID **/
	private Integer parentId;
	/** 资源URI **/
	private String resUri;
	/** 资源级别 **/
	private Integer resLevel;
	/** 资源类型 1 菜单、2 页面、3 弹窗、4 BANNER **/
	private Integer resType;
	/** 资源序号 **/
	private Integer resSeq;
	/** 状态 0 无效、1 有效 **/
	private String status;
	/** 创建人 **/
	private String createBy;
	/** 创建时间 yyyy-mm-dd hh24:mi:ss **/
	private String createTime;
	/** 修改人 **/
	private String modifyBy;
	/** 修改时间 yyyy-mm-dd hh24:mi:ss **/
	private String modifyTime;
	/** 资源所属模块 **/
	private Integer resModule;
	/** 链接地址**/
	private String resLink;
	/** 截止时间 yyyy-mm-dd hh24:mi:ss **/
	private String endTime;

	public Resource() {
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getResUri() {
		return resUri;
	}

	public void setResUri(String resUri) {
		this.resUri = resUri;
	}

	public Integer getResLevel() {
		return resLevel;
	}

	public void setResLevel(Integer resLevel) {
		this.resLevel = resLevel;
	}

	public Integer getResType() {
		return resType;
	}

	public void setResType(Integer resType) {
		this.resType = resType;
	}

	public Integer getResSeq() {
		return resSeq;
	}

	public void setResSeq(Integer resSeq) {
		this.resSeq = resSeq;
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

	public Integer getResModule() {
		return resModule;
	}

	public void setResModule(Integer resModule) {
		this.resModule = resModule;
	}

	public String getResLink() {
		return resLink;
	}

	public void setResLink(String resLink) {
		this.resLink = resLink;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
