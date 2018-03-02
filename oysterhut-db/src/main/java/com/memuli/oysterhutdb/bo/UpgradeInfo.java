package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class UpgradeInfo extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	/** 编号 **/
	private Integer UpgradeId;
	
	/** 客户端名称 **/
	private String appName;
	
	/** 客户端版本号 **/
	private String appVersion;
	
	/** 客户端版本类型   比如：（iOS）1 标准版、2 专业版、3 活动版 （android）0 默认版本 **/
	private String appType;
	
	/** 状态0 待审核、1 审核通过 **/
	private String status;
	
	/** 创建时间 **/
	private String createTime;
	
	/** 更新时间 **/
	private String updateTime;
	
	/** 弹框提示信息 **/
	private String alertMessage;
	
	/** 更新类型  1 强制更新、2 引导更新 **/
	private Integer alertType;

	public Integer getUpgradeId() {
		return UpgradeId;
	}

	public void setUpgradeId(Integer upgradeId) {
		UpgradeId = upgradeId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	public Integer getAlertType() {
		return alertType;
	}

	public void setAlertType(Integer alertType) {
		this.alertType = alertType;
	}
	
}
