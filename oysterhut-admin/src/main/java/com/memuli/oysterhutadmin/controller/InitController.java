package com.memuli.oysterhutadmin.controller;

import com.memuli.oysterhutadmin.util.Captcha;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 启动到登录页面
 */
@RestController
public class InitController {
    @GetMapping("/")
    public ModelAndView tologinHtml() {
        return new ModelAndView("/login.html");
    }

    /**
     * 获取验证码Jpg
     */
    @GetMapping(value="/getJpgCode")
    public void getJpgCode(HttpServletRequest request,HttpServletResponse response){
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpg");
            //jpg格式动画验证码:宽，高，位数
            Captcha captcha = new Captcha(140,30,4);
            //输出
            captcha.out(response.getOutputStream(),request);
        } catch (Exception e) {
            System.err.println("获取验证码异常："+e.getMessage());
        }
    }

}
