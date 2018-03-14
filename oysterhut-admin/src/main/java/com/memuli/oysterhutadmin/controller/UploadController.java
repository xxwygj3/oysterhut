package com.memuli.oysterhutadmin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping("/uploadImg")
    public void uploadImg(@RequestParam("upload") MultipartFile file, HttpServletRequest request,
                          HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");

            LOGGER.info("<==============富文本框图片上传开始==============>");
            // 上传地址 ：绝对路径(Web项目的全路径)+模块
            String path = request.getSession().getServletContext().getRealPath("/uploadImg/");
            String fileName = UUID.randomUUID().toString().replace("-", "");
            if (file.getContentType().equals("image/jpeg")) {
                fileName += ".jpg";
            } else if (file.getContentType().equals("image/png")) {
                fileName += ".png";
            } else if (file.getContentType().equals("image/gif")) {
                fileName += ".gif";
            } else if (file.getContentType().equals("image/bmp")) {
                fileName += ".bmp";
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'',"
                        + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
                out.println("</script>");
                return;
            }

            LOGGER.info("上传图片保存路径：" + path + fileName);
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File targetFile = new File(path, fileName);

            // 写入文件
            file.transferTo(targetFile);
            // 保存文件上传路径
            String baseRequestUrl = request.getRequestURL().toString();//得到请求的资源
            String requestUrl = baseRequestUrl + "/" + fileName;
            LOGGER.info("上传图片访问路径：" + requestUrl);
            // 返回“图像”选项卡并显示图片
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ", '" + requestUrl
                    + "');</script>");
            out.println("</script>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("<==============富文本框图片上传结束==============>");
    }
}
