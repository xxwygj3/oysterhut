package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

/** 系统统计汇总表历史表 **/
public class SysStatisticsHis extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 编号 自增长 **/
	private Integer hisId;
	/** 统计汇总编号 **/
	private Integer stsId;
	/** 统计项目关键字 **/
	private String stsKey;
	/** 统计值 **/
	private BigDecimal stsNum;
	/** 统计项目名称 **/
	private String stsName;
	/** 统计日期(yyyy-mm-dd) **/
	private String stsDate;
	/** 统计时间(yyyy-mm-dd hh:mm:ss) **/
	private String stsTime;
	/** 归档时间(yyyy-mm-dd hh:mm:ss) **/
	private String hisTime;

	public Integer getHisId() {
		return hisId;
	}

	public void setHisId(Integer hisId) {
		this.hisId = hisId;
	}

	public Integer getStsId() {
		return stsId;
	}

	public void setStsId(Integer stsId) {
		this.stsId = stsId;
	}

	public String getStsKey() {
		return stsKey;
	}

	public void setStsKey(String stsKey) {
		this.stsKey = stsKey;
	}

	public BigDecimal getStsNum() {
		return stsNum;
	}

	public void setStsNum(BigDecimal stsNum) {
		this.stsNum = stsNum;
	}

	public String getStsName() {
		return stsName;
	}

	public void setStsName(String stsName) {
		this.stsName = stsName;
	}

	public String getStsDate() {
		return stsDate;
	}

	public void setStsDate(String stsDate) {
		this.stsDate = stsDate;
	}

	public String getStsTime() {
		return stsTime;
	}

	public void setStsTime(String stsTime) {
		this.stsTime = stsTime;
	}

	public String getHisTime() {
		return hisTime;
	}

	public void setHisTime(String hisTime) {
		this.hisTime = hisTime;
	}

}
