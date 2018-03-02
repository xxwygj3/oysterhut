package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
/**
 * 尊享码明细表
 */
public class VipCodeDet extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 明细ID 自增长 **/
	private Integer detId;
	/** 尊享码 **/
	private String vipCode;
	/** 标的编号 **/
	private String prdCode;
	/** 备注 **/
	private String remark;
	/** 创建人 **/
	private String createBy;
	/** 创建时间 yyyy-mm-dd hh24:mi:ss **/
	private String createTime;

	public Integer getDetId() {
		return detId;
	}

	public void setDetId(Integer detId) {
		this.detId = detId;
	}

	public String getVipCode() {
		return vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
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
