/**   
 * @Title: Bank.java 
 * @Package com.joinwe.pbap.bo 
 * @author yf
 * @date 2015年1月21日 下午1:41:52 
 */
package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/**
 * @ClassName: Bank
 * @Description: 系统支持银行表
 * @author yf
 * @date 2015年1月21日 下午1:41:52
 */
public class Bank extends BaseEntity {

	private static final long serialVersionUID = 1L;
	// 银行ID
	protected Integer bankId;
	// 银行名
	protected String bankName;
	// 银行图标路径
	protected String bankIconUri;
	// 银行号
	protected String bankCode;
	// 交易限额
	protected String trdLimit;

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	// 备注
	protected String remark;
	// 状态 0 无效、1 有效
	protected String status;
	// 创建人
	protected String createBy;
	// 创建时间 yyyy-mm-dd hh24:mi:ss
	protected String createTime;
	// 修改人
	protected String modifyBy;
	// 修改时间
	protected String modifyTime;

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankIconUri() {
		return bankIconUri;
	}

	public void setBankIconUri(String bankIconUri) {
		this.bankIconUri = bankIconUri;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getTrdLimit() {
		return trdLimit;
	}

	public void setTrdLimit(String trdLimit) {
		this.trdLimit = trdLimit;
	}
}
