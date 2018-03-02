package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class News extends BaseEntity{

	private static final long serialVersionUID = 1L;
    /** 新闻ID **/
	private Integer newsId;
	/** 新闻标题 **/
	private String newsTitle;
	/** 新闻内容 **/
	private String newsContent;
	/** 发布时间**/
	private String newsTime;
	/** 状态 0 无效、1 有效 **/
	private String status;
	/** 新闻排序 **/
	private Integer newsSeq;
	/** 类型 0 新闻、1 公告 **/
	private String newsType;
	/** 结束时间**/
	private String endTime;
	/** 图片地址 **/
	private String resUri;
	
	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(String newsTime) {
		this.newsTime = newsTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNewsSeq() {
		return newsSeq;
	}

	public void setNewsSeq(Integer newsSeq) {
		this.newsSeq = newsSeq;
	}

	public String getNewsType() {
		return newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getResUri() {
		return resUri;
	}

	public void setResUri(String resUri) {
		this.resUri = resUri;
	}
}
