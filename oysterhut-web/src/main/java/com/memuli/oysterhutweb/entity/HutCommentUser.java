package com.memuli.oysterhutweb.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("u_cmt_user")
public class HutCommentUser extends Model<HutComment> {
    private Integer id;
    /**
     * 评论编号 生成规则：CMT+YYMMDDHHmmSS+5位序列
     */
    @TableField(value = "cmt_code")
    private String cmtCode;
    /**
     * 用户类型 1评论人、2回复人
     */
    @TableField(value = "user_type")
    private Integer userType;
    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户IP
     */
    @TableField(value = "user_ip")
    private String userIp;

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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
