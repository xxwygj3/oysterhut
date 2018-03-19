package com.memuli.oysterhutadmin.util;

import java.io.Serializable;

public class ReqData implements Serializable {

    private String order;
    private Integer offset;
    private Integer limit;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
