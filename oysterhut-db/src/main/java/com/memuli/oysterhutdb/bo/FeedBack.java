package com.memuli.oysterhutdb.bo;


import com.memuli.oysterhutcommon.BaseEntity;

public class FeedBack extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/** 用户反馈主键 **/
	private Integer feedId;
	/** 用户编号 **/
	private String cusCode;
	/** 反馈内容 **/
	private String feedContent;
	/** 反馈时间 **/
	private String feedDate;

	public Integer getFeedId() {
		return feedId;
	}

	public void setFeedId(Integer feedId) {
		this.feedId = feedId;
	}

	public String getCusCode() {
		return cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}

	public String getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(String feedDate) {
		this.feedDate = feedDate;
	}

}
