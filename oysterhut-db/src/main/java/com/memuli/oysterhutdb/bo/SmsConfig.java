package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
/**
 * 短信配置表
 * @author bc
 */
public class SmsConfig extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private String smsId;
	/** 配置类型：1、满标 **/
	private Integer smsType;
	/** 手机号 **/
	private String smsPhone;
	/** 姓名 **/
	private String smsName;
	/** 状态：0、无用  1、可用 **/
	private Integer smsStatus;

	public String getSmsId() {
		return smsId;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public Integer getSmsType() {
		return smsType;
	}

	public void setSmsType(Integer smsType) {
		this.smsType = smsType;
	}

	public String getSmsPhone() {
		return smsPhone;
	}

	public void setSmsPhone(String smsPhone) {
		this.smsPhone = smsPhone;
	}

	public String getSmsName() {
		return smsName;
	}

	public void setSmsName(String smsName) {
		this.smsName = smsName;
	}

	public Integer getSmsStatus() {
		return smsStatus;
	}

	public void setSmsStatus(Integer smsStatus) {
		this.smsStatus = smsStatus;
	}

}
