package com.memuli.oysterhutadmin.controller;

import com.memuli.oysterhutadmin.config.UploadConfig;
import com.memuli.oysterhutadmin.entity.SysUser;
import com.memuli.oysterhutadmin.service.HutNewsService;
import com.memuli.oysterhutadmin.service.HutRotatePicService;
import com.memuli.oysterhutadmin.service.SysUserService;
import com.memuli.oysterhutadmin.util.MessageSourceAccessor;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    public SysUser getCurrentUser() {
        SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        return loginUser;
    }

    @Autowired
    protected MessageSourceAccessor msa;
    @Autowired
    protected UploadConfig uploadConfig;
    @Autowired
    protected HutNewsService hutNewsService;
    @Autowired
    protected SysUserService sysUserService;
    @Autowired
    protected HutRotatePicService hutRotatePicService;
}
