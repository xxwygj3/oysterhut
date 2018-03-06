package com.memuli.oysterhutadmin.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro权限控制登录Controller
 */
@RestController
public class LoginController {

    /**
     * 登录
     * @param username
     * @param password
     * @param vcode
     * @param rememberMe
     * @return
     */
    @PostMapping("/loginIn")
    public Map<String,Object> submitLogin(String username, String password,String vcode,Boolean rememberMe) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(StringUtils.isBlank(vcode)){
            resultMap.put("status", 500);
            resultMap.put("message", "验证码不能为空！");
            return resultMap;
        }
        Session session = SecurityUtils.getSubject().getSession();
        //转化成小写字母
        vcode = vcode.toLowerCase();
        String v = (String) session.getAttribute("_code");
        //还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
        session.removeAttribute("_come");
        if(!vcode.equals(v)){
            resultMap.put("status", 500);
            resultMap.put("message", "验证码错误！");
            return resultMap;
        }
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
            SecurityUtils.getSubject().login(token);
            resultMap.put("status",200);
            resultMap.put("message","登录成功");
        }catch (Exception e){
            resultMap.put("status",500);
            resultMap.put("message",e.getMessage());
        }
        return resultMap;
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/loginOut")
    public Map<String,Object> logout(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            //退出
            SecurityUtils.getSubject().logout();
            resultMap.put("status",200);
            resultMap.put("message","退出成功");
        } catch (Exception e) {
            resultMap.put("status",500);
            resultMap.put("message",e.getMessage());
        }
        return resultMap;
    }
}
