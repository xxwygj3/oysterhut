package com.memuli.oysterhutadmin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("u_role")
public class SysRole extends Model<SysRole> {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色类型
     */
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    /** 指定主键 */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
