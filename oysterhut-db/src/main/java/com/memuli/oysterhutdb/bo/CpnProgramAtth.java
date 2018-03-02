package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class CpnProgramAtth extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
 
    /** 附加信息ID 自增长 **/
    private Integer atthId;
    /** 计划编号 **/
    private String prmCode;
    /** 派发场景 01 注册、02 开户 03 绑卡 04 投标 （|分割） **/
    private String prmDisScene;
    /** 适用产品 7 月月喜、8 季季宝、9 双季盈、10 年年余、30 新手专项（|分割） **/
    private String prmApply;
    /** 使用条件 最低投资金额等 **/
    private String prmProps;
 
    public Integer getAtthId() {
        return atthId;
    }
 
    public void setAtthId(Integer atthId) {
        this.atthId = atthId;
    }
 
    public String getPrmCode() {
        return prmCode;
    }
 
    public void setPrmCode(String prmCode) {
        this.prmCode = prmCode;
    }
 
    public String getPrmDisScene() {
        return prmDisScene;
    }
 
    public void setPrmDisScene(String prmDisScene) {
        this.prmDisScene = prmDisScene;
    }
 
    public String getPrmApply() {
        return prmApply;
    }
 
    public void setPrmApply(String prmApply) {
        this.prmApply = prmApply;
    }
 
    public String getPrmProps() {
        return prmProps;
    }
 
    public void setPrmProps(String prmProps) {
        this.prmProps = prmProps;
    }
 
}
