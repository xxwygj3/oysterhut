package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/* 消息通知表 */
public class Booking extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 预约ID **/
	private Integer bookId;
	/** 预约产品类型1 利融宝、2 利保宝、3 利担保 **/
	private String prdType;
	/** 预约人手机号 **/
	private String bookMobile;
	/** 所在城市 **/
	private String city;
	/** 预约公司 **/
	private Integer bookCompany;
	/** 预约日期 **/
	private String bookDate;
	/** 预约时间 **/
	private String bookTime;
	/** 客户编号  **/
	private String cusCode;
	/** 用户名  **/
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCusCode() {
		return cusCode;
	}
	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}
	
	public Booking() {
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getPrdType() {
		return prdType;
	}

	public void setPrdType(String prdType) {
		this.prdType = prdType;
	}

	public String getBookMobile() {
		return bookMobile;
	}

	public void setBookMobile(String bookMobile) {
		this.bookMobile = bookMobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getBookCompany() {
		return bookCompany;
	}

	public void setBookCompany(Integer bookCompany) {
		this.bookCompany = bookCompany;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookTime() {
		return bookTime;
	}

	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	
	
}
