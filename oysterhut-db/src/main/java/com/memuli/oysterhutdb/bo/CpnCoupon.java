package com.memuli.oysterhutdb.bo;


import com.memuli.oysterhutcommon.BaseEntity;

public class CpnCoupon extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 优惠券ID 自增长 **/
	private Integer cpnId;
	/** 优惠券编号 **/
	private String cpnCode;
	/** 优惠类型 01 加息券 **/
	private String cpnType;
	/** 优惠内容 加息额度（%）、优惠金额（元）等，和类型对应 **/
	private String cpnInfo;
	/** 有效期 以天为计划单位 **/
	private Integer cpnLimit;
	/** 适用产品 7 月月喜、8 季季宝、9 双季盈、10 年年余、30 新手专项（|分割） **/
	private String cpnApply;
	/** 使用条件 最低投资金额等 **/
	private String cpnProps;
	/** 卡券来源 **/
	private String cpnOrigin;

	public Integer getCpnId() {
		return cpnId;
	}

	public void setCpnId(Integer cpnId) {
		this.cpnId = cpnId;
	}

	public String getCpnCode() {
		return cpnCode;
	}

	public void setCpnCode(String cpnCode) {
		this.cpnCode = cpnCode;
	}

	public String getCpnType() {
		return cpnType;
	}

	public void setCpnType(String cpnType) {
		this.cpnType = cpnType;
	}

	public String getCpnInfo() {
		return cpnInfo;
	}

	public void setCpnInfo(String cpnInfo) {
		this.cpnInfo = cpnInfo;
	}

	public Integer getCpnLimit() {
		return cpnLimit;
	}

	public void setCpnLimit(Integer cpnLimit) {
		this.cpnLimit = cpnLimit;
	}

	public String getCpnApply() {
		return cpnApply;
	}

	public void setCpnApply(String cpnApply) {
		this.cpnApply = cpnApply;
	}

	public String getCpnProps() {
		return cpnProps;
	}

	public void setCpnProps(String cpnProps) {
		this.cpnProps = cpnProps;
	}

	public String getCpnOrigin() {
		return cpnOrigin;
	}

	public void setCpnOrigin(String cpnOrigin) {
		this.cpnOrigin = cpnOrigin;
	}

}
