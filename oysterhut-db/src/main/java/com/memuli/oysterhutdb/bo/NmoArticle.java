package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class NmoArticle extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 文章编号 **/
	private Integer artId;
	/** 文章标题 **/
	private String artTitle;
	/** 文章简介 **/
	private String artIntro;
	/** 文章类型 0 原创、1 金融那些事、2 大师兄聊八卦 **/
	private Integer artType;
	/** 标题配图uri **/
	private String titleUri;
	/** 跳转链接 **/
	private String artLink;
	/** 排序 **/
	private Integer artOrder;
	/** 状态 0 无效、1 有效 **/
	private Integer status;
	/** 创建人 **/
	private String createBy;
	/** 创建时间 yyyy-mm-dd hh24:mi:ss **/
	private String createTime;
	/** 修改人 **/
	private String modifyBy;
	/** 修改时间 yyyy-mm-dd hh24:mi:ss **/
	private String modifyTime;

	public Integer getArtId() {
		return artId;
	}

	public void setArtId(Integer artId) {
		this.artId = artId;
	}

	public String getArtTitle() {
		return artTitle;
	}

	public void setArtTitle(String artTitle) {
		this.artTitle = artTitle;
	}

	public String getArtIntro() {
		return artIntro;
	}

	public void setArtIntro(String artIntro) {
		this.artIntro = artIntro;
	}

	public Integer getArtType() {
		return artType;
	}

	public void setArtType(Integer artType) {
		this.artType = artType;
	}

	public String getTitleUri() {
		return titleUri;
	}

	public void setTitleUri(String titleUri) {
		this.titleUri = titleUri;
	}

	public String getArtLink() {
		return artLink;
	}

	public void setArtLink(String artLink) {
		this.artLink = artLink;
	}

	public Integer getArtOrder() {
		return artOrder;
	}

	public void setArtOrder(Integer artOrder) {
		this.artOrder = artOrder;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

}
