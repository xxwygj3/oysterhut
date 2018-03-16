package com.memuli.oysterhutadmin.util;

public class ResultInfo {
    /**
     * 结果代码
     **/
    private Integer status;
    /**
     * 结果信息
     **/
    private String message;

    public ResultInfo() {
    }

    public ResultInfo(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
