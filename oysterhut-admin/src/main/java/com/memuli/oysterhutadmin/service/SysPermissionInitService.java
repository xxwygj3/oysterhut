package com.memuli.oysterhutadmin.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.memuli.oysterhutadmin.dao.SysPermissionInitMapper;
import com.memuli.oysterhutadmin.entity.SysPermissionInit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionInitService extends ServiceImpl<SysPermissionInitMapper,SysPermissionInit>{
    public List<SysPermissionInit> selectAll() {
        return baseMapper.selectAll();
    }
}
