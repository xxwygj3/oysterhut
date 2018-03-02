package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.sql.Date;

/**
 * 客户端接入配置实体
 */
public class ChannelAccess extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String appid;
	private String secret;
	private String channel;
	private Date appExpireDate;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Date getAppExpireDate() {
		return appExpireDate;
	}
	public void setAppExpireDate(Date appExpireDate) {
		this.appExpireDate = appExpireDate;
	}
	
}
