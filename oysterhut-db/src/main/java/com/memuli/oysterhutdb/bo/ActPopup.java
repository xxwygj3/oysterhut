package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class ActPopup extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/** POPUP编号 **/
	private Integer popId;
	/** POPUP图片uri **/
	private String popUri;
	/** POPUP链接 **/
	private String popLink;
	/** POPUP描述 **/
	private String popDescription;
	/** 状态  0 不显示 1 显示 **/
	private Integer status;
	/** 修改人 **/
	private String modifyBy;
	/** 修改时间  yyyy-mm-dd hh24:mi:ss **/
	private String modifyTime;
	/**活动ID*/
	private Integer actPrjId;
	/**活动开始时间 yyyy-mm-dd hh24:mi:ss*/
	private String actStartTime;
	/**活动结束时间 yyyy-mm-dd hh24:mi:ss*/
	private String actEndTime;
	public Integer getPopId() {
		return popId;
	}
	public void setPopId(Integer popId) {
		this.popId = popId;
	}
	public String getPopUri() {
		return popUri;
	}
	public void setPopUri(String popUri) {
		this.popUri = popUri;
	}
	public String getPopLink() {
		return popLink;
	}
	public void setPopLink(String popLink) {
		this.popLink = popLink;
	}
	public String getPopDescription() {
		return popDescription;
	}
	public void setPopDescription(String popDescription) {
		this.popDescription = popDescription;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public Integer getActPrjId() {
		return actPrjId;
	}
	public void setActPrjId(Integer actPrjId) {
		this.actPrjId = actPrjId;
	}
	public String getActStartTime() {
		return actStartTime;
	}
	public void setActStartTime(String actStartTime) {
		this.actStartTime = actStartTime;
	}
	public String getActEndTime() {
		return actEndTime;
	}
	public void setActEndTime(String actEndTime) {
		this.actEndTime = actEndTime;
	}
	
	
	  
	  
}
