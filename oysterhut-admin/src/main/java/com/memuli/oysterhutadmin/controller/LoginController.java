package com.memuli.oysterhutadmin.controller;

import com.memuli.oysterhutadmin.constant.ResultCode;
import com.memuli.oysterhutadmin.util.HandleException;
import com.memuli.oysterhutadmin.util.MessageSourceAccessor;
import com.memuli.oysterhutadmin.util.RespData;
import com.memuli.oysterhutadmin.util.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * shiro权限控制登录Controller
 */
@RestController
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private MessageSourceAccessor msa;
    /**
     * 登录
     */
    @PostMapping("/loginSystem")
    public RespData loginSystem(String username, String password, String vcode) {
        LOGGER.info("LoginController.loginSystem (登录) Request Parameters:{'username':"+username+",'password':"+password+",'vcode':"+vcode+"}");
        RespData respData = new RespData();
        try {
            if(StringUtils.isBlank(vcode)){
                throw new HandleException(ResultCode.CODE_001, msa.getMessage(ResultCode.CODE_001,"验证码"));
            }
            if(StringUtils.isBlank(username)){
                throw new HandleException(ResultCode.CODE_001, msa.getMessage(ResultCode.CODE_001,"用户名"));
            }
            if(StringUtils.isBlank(password)){
                throw new HandleException(ResultCode.CODE_001, msa.getMessage(ResultCode.CODE_001,"密码"));
            }
            Session session = SecurityUtils.getSubject().getSession();
            //转化成小写字母
            vcode = vcode.toLowerCase();
            String v = (String) session.getAttribute("_code");
            //还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
            session.removeAttribute("_come");
            if(!vcode.equals(v)){
                throw new HandleException(ResultCode.CODE_002, msa.getMessage(ResultCode.CODE_002));
            }
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            SecurityUtils.getSubject().login(token);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        }catch (DisabledAccountException dae) {
            LOGGER.error("LoginController.loginSystem (登录) HandleException",dae);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_004,msa.getMessage(ResultCode.CODE_004)));
        }catch (AccountException ae) {
            LOGGER.error("LoginController.loginSystem (登录) HandleException",ae);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_003,msa.getMessage(ResultCode.CODE_003)));
        }catch (HandleException hle) {
            LOGGER.error("LoginController.loginSystem (登录) HandleException",hle);
            respData.setResultInfo(hle.getResultInfo());
        }catch (Exception e){
            LOGGER.error("LoginController.loginSystem (登录) Exception",e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("LoginController.loginSystem (登录) Response parameter:"+ respData.toJsonString());
        return respData;
    }

    /**
     * 退出
     */
    @GetMapping("/logoutSystem")
    public RespData logoutSystem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("LoginController.logoutSystem (退出) Request Parameters:");
        RespData respData = new RespData();
        try {
            Subject subject = SecurityUtils.getSubject();
            LOGGER.info("LoginController.logoutSystem (退出) 是否已经登陆验证通过了："+SecurityUtils.getSubject().isAuthenticated());
            if(subject.isAuthenticated()){
                subject.logout();//退出
            }
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (Exception e) {
            LOGGER.error("LoginController.logoutSystem (退出) Exception",e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("LoginController.logoutSystem (退出) Response parameter:"+ respData.toJsonString());
        return respData;
    }
}
