package com.memuli.oysterhutweb.controller;


import com.memuli.oysterhutweb.util.Captcha;
import com.memuli.oysterhutweb.util.MessageSourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 启动到登录页面
 */
@RestController
public class InitController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitController.class);
    @Autowired
    private MessageSourceAccessor msa;
    /**
     * 域名访问重定向到登录页面
     */
    @GetMapping("/")
    public ModelAndView tologinHtml() {
        return new ModelAndView("/index.html");
    }

    /**
     * 获取验证码Jpg
     */
    @GetMapping(value="/getJpgCode")
    public void getJpgCode(HttpServletRequest request,HttpServletResponse response){
        LOGGER.info("InitController.getJpgCode (获取验证码) Request Parameters:开始");
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
            LOGGER.error("InitController.getJpgCode (获取验证码) Exception",e);
        }
        LOGGER.info("InitController.getJpgCode (获取验证码) Response Parameters:结束");
    }

}
