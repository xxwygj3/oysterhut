package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

/**
 * 省市信息表
 * @author Zkp
 *
 */
public class Area extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/** ID **/
	private Integer areaId;
	/** 省/市Code **/
	private String areaCode;
	/** 省/市 **/
	private String areaName;
	/** 省市关联 **/
	private String parentId;
	/** 0 无效、1 有效 **/
	private Integer status;
	/** 1省/直辖市、2市、3县 **/
	private String grade;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
