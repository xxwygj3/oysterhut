package com.memuli.oysterhutweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/show")
    public String show() {
        return "欢迎访问牡蛎小屋";
    }
}
