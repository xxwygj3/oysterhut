package com.memuli.oysterhutadmin.controller;

import com.memuli.oysterhutadmin.config.UploadConfig;
import com.memuli.oysterhutadmin.constant.ResultCode;
import com.memuli.oysterhutadmin.entity.SysUser;
import com.memuli.oysterhutadmin.service.HutNewsService;
import com.memuli.oysterhutadmin.service.HutRotatePicService;
import com.memuli.oysterhutadmin.service.SysUserService;
import com.memuli.oysterhutadmin.util.HandleException;
import com.memuli.oysterhutadmin.util.MessageSourceAccessor;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

public class BaseController {
    public SysUser getCurrentUser() {
        SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        return loginUser;
    }

    protected String getRequestImgUrl(MultipartFile[] files,HttpServletRequest request,String uppath)throws Exception{
        long size = 3 * 1024 * 1024;
        if (files[0].getSize() > size) {
            throw new HandleException(ResultCode.CODE_009, msa.getMessage(ResultCode.CODE_009));
        }
        StringBuffer pathStringBuffer = new StringBuffer(request.getSession().getServletContext().getRealPath("/"));
        pathStringBuffer.append(uppath);
        String path = pathStringBuffer.toString();
        String fileName = UUID.randomUUID().toString().replace("-", "");
        if (files[0].getContentType().equals("image/jpeg")) {
            fileName += ".jpg";
        } else if (files[0].getContentType().equals("image/png")) {
            fileName += ".png";
        } else if (files[0].getContentType().equals("image/gif")) {
            fileName += ".gif";
        } else if (files[0].getContentType().equals("image/bmp")) {
            fileName += ".bmp";
        } else {
            throw new HandleException(ResultCode.CODE_008, msa.getMessage(ResultCode.CODE_008,files[0].getContentType()));
        }
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File targetFile = new File(path, fileName);
        // 写入文件
        files[0].transferTo(targetFile);
        // 保存文件上传路径
        StringBuffer requestUrlStringBuffer = new StringBuffer(uploadConfig.getRequestUrl());
        requestUrlStringBuffer.append(uppath).append(fileName);
        return requestUrlStringBuffer.toString();
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
