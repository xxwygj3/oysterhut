package com.memuli.oysterhutweb.util;

import com.memuli.oysterhutcommon.BaseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class RespData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private ResultInfo resultInfo;
    private Map<String, Object> resultMap;

    public RespData() {
        resultMap = new LinkedHashMap<String, Object>();
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public void addObject(String key, Object value) {
        resultMap.put(key, value);
    }

    public void removeObject(String key) {
        resultMap.remove(key);
    }
}
