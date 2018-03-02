package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/**
 * 尊享码信息表
 */
public class VipCode extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/** 编码ID 自增长 **/
	private Integer vipId;
	/** 尊享码 **/
	private String vipCode;
	/** 状态 0 无效、1 有效 **/
	private String status;
	/** 备注 **/
	private String remark;
	/** 创建人 **/
	private String createBy;
	/** 创建时间 yyyy-mm-dd hh24:mi:ss **/
	private String createTime;

	public Integer getVipId() {
		return vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

	public String getVipCode() {
		return vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

}
