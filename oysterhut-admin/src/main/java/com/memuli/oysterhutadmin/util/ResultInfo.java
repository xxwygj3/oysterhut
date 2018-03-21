package com.memuli.oysterhutadmin.util;

public class ResultInfo {
    /**
     * 结果代码
     **/
    private String status;
    /**
     * 结果信息
     **/
    private String message;

    public ResultInfo() {
    }

    public ResultInfo(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
