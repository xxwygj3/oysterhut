package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.util.Date;

/**
 * 客户基本信息附加表
 */
public class CustomerAtth extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 客户编号 **/
	private String cusCode;
	
	/** 客户出生日期 **/
	private String cusBirthDate;
	
	/** 客户星座 **/
	private String cusStar;
	
	/** 客户性别 **/
	private String cusGender;
    
    /** 县级 **/
    private Integer countyCode;
    
    /** 市级 **/
    private Integer cityCode;
    
    /** 省级 **/
    private Integer provinceCode;
	
	/** 修改时间 **/
	private Date modifyTime;

	
	public CustomerAtth() {
		super();
	}

	public CustomerAtth(String cusCode) {
		super();
		this.cusCode = cusCode;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getCusBirthDate() {
		return cusBirthDate;
	}

	public void setCusBirthDate(String cusBirthDate) {
		this.cusBirthDate = cusBirthDate;
	}

	public String getCusStar() {
		return cusStar;
	}

	public void setCusStar(String cusStar) {
		this.cusStar = cusStar;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCusGender() {
		return cusGender;
	}

	public void setCusGender(String cusGender) {
		this.cusGender = cusGender;
	}

	public Integer getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(Integer countyCode) {
		this.countyCode = countyCode;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}
	@Override
	public String toString() {
		return "CustomerAtth [cusCode=" + cusCode + ", cusBirthDate=" + cusBirthDate + ", cusStar=" + cusStar
				+ ", cusGender=" + cusGender + ", countyCode=" + countyCode + ", cityCode=" + cityCode
				+ ", provinceCode=" + provinceCode + ", modifyTime=" + modifyTime + "]";
	}

}
