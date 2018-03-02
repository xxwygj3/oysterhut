package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;

import java.util.Date;

/**用户登录历史表
 * @author Jolion
 * @date 2017年5月23日上午10:56:40
 */
public class LoginHistory extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** ID **/
	private Integer id;
	/** 手机号 **/
	private String cusMobile;
	/** 登录时间 **/
	private Date loginTime;
	/** 登录IP **/
	private String loginIP;
	/** 登录状态 0:失败 1:成功 **/
	private String loginStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusMobile() {
		return cusMobile;
	}
	public void setCusMobile(String cusMobile) {
		this.cusMobile = cusMobile;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	
}
