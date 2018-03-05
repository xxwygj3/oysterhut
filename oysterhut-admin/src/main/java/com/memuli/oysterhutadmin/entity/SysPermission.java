package com.memuli.oysterhutadmin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("u_permission")
public class SysPermission extends Model<SysPermission> {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * url地址
     */
    private String url;
    /**
     * url描述
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /** 指定主键 */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
