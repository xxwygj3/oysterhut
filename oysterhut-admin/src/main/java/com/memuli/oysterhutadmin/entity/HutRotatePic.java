package com.memuli.oysterhutadmin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("u_rotate_picture")
public class HutRotatePic extends Model<HutRotatePic> {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 2001 首页轮换图片
     */
    @TableField(value = "rotate_picture_type")
    private String rotatePictureType;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片地址
     */
    @TableField(value = "img_url")
    private String imgUrl;
    /**
     * 显示顺序
     */
    @TableField(value = "display_order")
    private Integer displayOrder;
    /**
     * 链接地址
     */
    @TableField(value = "link_url")
    private String linkUrl;
    /**
     * 状态 8有效、9无效
     */
    private String state;
    /**
     * 到期时间
     */
    @TableField(value = "expire_time")
    private Date expireTime;
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

    public String getRotatePictureType() {
        return rotatePictureType;
    }

    public void setRotatePictureType(String rotatePictureType) {
        this.rotatePictureType = rotatePictureType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
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
}

