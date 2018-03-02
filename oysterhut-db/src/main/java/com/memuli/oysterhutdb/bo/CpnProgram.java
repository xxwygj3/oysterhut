package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

public class CpnProgram extends BaseEntity{
 
    private static final long serialVersionUID = 1L;
    
      /** 计划ID 自增长 **/
      private Integer prmId;
      /** 计划编号 **/
      private String prmCode;
      /** 优惠券编号 **/
      private String cpnCode;
      /** 生效时间 yyyy-mm-dd hh24:mi:ss **/
      private String prmBeginTime;
      /** 失效时间 yyyy-mm-dd hh24:mi:ss **/
      private String prmEndTime;
      /** 生效状态 1、有时效 2、无限期 **/
      private Integer prmValidType;
      /** 计划说明 **/
      private String prmDesc;
      /** 状态 0 无效、1 有效 **/
      private String status;
      /** 创建人 创建人 **/
      private String createBy;
      /** 创建时间 创建时间 **/
      private String createTime;
      /** 修改人 修改人 **/
      private String modifyBy;
      /** 修改时间 修改时间 **/
      private String modifyTime;
      
    public Integer getPrmId() {
        return prmId;
    }
    public void setPrmId(Integer prmId) {
        this.prmId = prmId;
    }
    public String getPrmCode() {
        return prmCode;
    }
    public void setPrmCode(String prmCode) {
        this.prmCode = prmCode;
    }
    public String getCpnCode() {
        return cpnCode;
    }
    public void setCpnCode(String cpnCode) {
        this.cpnCode = cpnCode;
    }
    public String getPrmBeginTime() {
        return prmBeginTime;
    }
    public void setPrmBeginTime(String prmBeginTime) {
        this.prmBeginTime = prmBeginTime;
    }
    public String getPrmEndTime() {
        return prmEndTime;
    }
    public void setPrmEndTime(String prmEndTime) {
        this.prmEndTime = prmEndTime;
    }
    public Integer getPrmValidType() {
        return prmValidType;
    }
    public void setPrmValidType(Integer prmValidType) {
        this.prmValidType = prmValidType;
    }
    public String getPrmDesc() {
        return prmDesc;
    }
    public void setPrmDesc(String prmDesc) {
        this.prmDesc = prmDesc;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getModifyBy() {
        return modifyBy;
    }
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }
    public String getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
      
}
