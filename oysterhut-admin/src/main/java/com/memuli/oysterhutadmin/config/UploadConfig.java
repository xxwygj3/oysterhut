package com.memuli.oysterhutadmin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UploadConfig {
    // 访问图片地址
    @Value("${upload.requset.url}")
    private String requestUrl;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
