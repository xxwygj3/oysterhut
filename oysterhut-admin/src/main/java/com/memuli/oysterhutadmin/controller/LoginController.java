package com.memuli.oysterhutadmin.controller;

import com.baomidou.mybatisplus.activerecord.Model;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro权限控制登录Controller
 */
@RestController
@RequestMapping("login")
public class LoginController {

    //ajax登录请求
    @RequestMapping(value="ajaxLogin",method= RequestMethod.POST)
    public Map<String,Object> submitLogin(String username, String password, Model model) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            SecurityUtils.getSubject().login(token);
            resultMap.put("status",200);
            resultMap.put("message","登录成功");
        }catch (Exception e){
            resultMap.put("status",500);
            resultMap.put("message",e.getMessage());
        }
        return resultMap;
    }
}
