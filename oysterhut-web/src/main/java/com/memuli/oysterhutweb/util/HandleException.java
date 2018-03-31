package com.memuli.oysterhutweb.util;

/**
 * 自定义异常
 */
public class HandleException extends Exception {
    protected ResultInfo resultInfo;

    public HandleException(ResultInfo resultInfo) {
        super(resultInfo.getStatus() + "," + resultInfo.getMessage());
        this.resultInfo = resultInfo;
    }

    public HandleException(String status, String message) {
        super(status + "," + message);
        this.resultInfo = new ResultInfo();
        this.resultInfo.setStatus(status);
        this.resultInfo.setMessage(message);
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }
}
