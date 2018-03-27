package com.memuli.oysterhutadmin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("u_news")
public class HutNews extends Model<HutNews> {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 类型 1001牡蛎新闻、1002小屋新闻
     */
    @TableField(value = "news_type")
    private String newsType;
    /**
     * 标签 牡蛎价值、牡蛎产业、牡蛎美食、牡蛎养殖、小屋动态、小屋菜色、小屋装饰、小屋风景
     */
    @TableField(value = "news_tag")
    private String newsTag;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片地址
     */
    @TableField(value = "img_url")
    private String imgUrl;
    /**
     * 简介
     */
    private String summary;
    /**
     * 内容(clob)
     */
    private String content;
    /**
     * 显示顺序
     */
    @TableField(value = "display_order")
    private Integer displayOrder;
    /**
     * 状态 8有效、9无效
     */
    private String state;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time")
    private Date modifyTime;
    /**
     * 修改人
     */
    @TableField(value = "modify_by")
    private String modifyBy;
    /**
     * 来源类型 1原创、2转载
     */
    @TableField(value = "source_type")
    private Integer sourceType;
    /**
     * 来源描述
     */
    @TableField(value = "source_desc")
    private String sourceDesc;

    /**
     * 指定主键
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getNewsTag() {
        return newsTag;
    }

    public void setNewsTag(String newsTag) {
        this.newsTag = newsTag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceDesc() {
        return sourceDesc;
    }

    public void setSourceDesc(String sourceDesc) {
        this.sourceDesc = sourceDesc;
    }
}
