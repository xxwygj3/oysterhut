package com.memuli.oysterhutadmin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.memuli.oysterhutadmin.entity.SysPermissionInit;

import java.util.List;

/**
 * Mapper 接口
 */
public interface SysPermissionInitMapper extends BaseMapper<SysPermissionInit>{
    List<SysPermissionInit> selectAll();
}
