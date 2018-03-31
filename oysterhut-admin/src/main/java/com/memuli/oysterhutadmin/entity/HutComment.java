package com.memuli.oysterhutadmin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("u_comment")
public class HutComment extends Model<HutComment> {
    private Integer id;
    /**
     * 评论编号 生成规则：CMT+YYMMDDHHmmSS+5位序列
     */
    @TableField(value = "cmt_code")
    private String cmtCode;
    /**
     * 评论人用户昵称
     */
    @TableField(value = "cmt_nick_name")
    private String cmtNickName;
    /**
     * 类型 1评论、2回复
     */
    @TableField(value = "cmt_type")
    private String cmtType;
    /**
     * 主题ID
     */
    @TableField(value = "topic_id")
    private String topicId;
    /**
     * 内容
     */
    private String content;
    /**
     * 状态 8通过、9删除
     */
    private String state;
    /**
     * 评论时间
     */
    @TableField(value = "cmt_time")
    private Date cmtTime;
    /**
     * 客服回复状态 7未回复、8已回复
     */
    @TableField(value = "service_state")
    private String serviceState;
    /**
     * 客服回复内容
     */
    @TableField(value = "service_content")
    private String serviceContent;
    /**
     * 客服回复时间
     */
    @TableField(value = "service_time")
    private Date serviceTime;
    /**
     * 删除时间
     */
    @TableField(value = "del_time")
    private Date delTime;
    /**
     * 删除人
     */
    @TableField(value = "del_by")
    private String delBy;
    /**
     * 回复评论编号
     */
    @TableField(value = "reply_code")
    private String replyCode;
    /**
     * 回复人用户昵称
     */
    @TableField(value = "reply_nick_name")
    private String replyNickName;

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

    public String getCmtCode() {
        return cmtCode;
    }

    public void setCmtCode(String cmtCode) {
        this.cmtCode = cmtCode;
    }

    public String getCmtNickName() {
        return cmtNickName;
    }

    public void setCmtNickName(String cmtNickName) {
        this.cmtNickName = cmtNickName;
    }

    public String getCmtType() {
        return cmtType;
    }

    public void setCmtType(String cmtType) {
        this.cmtType = cmtType;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCmtTime() {
        return cmtTime;
    }

    public void setCmtTime(Date cmtTime) {
        this.cmtTime = cmtTime;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Date getDelTime() {
        return delTime;
    }

    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    public String getDelBy() {
        return delBy;
    }

    public void setDelBy(String delBy) {
        this.delBy = delBy;
    }

    public String getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(String replyCode) {
        this.replyCode = replyCode;
    }

    public String getReplyNickName() {
        return replyNickName;
    }

    public void setReplyNickName(String replyNickName) {
        this.replyNickName = replyNickName;
    }
}
