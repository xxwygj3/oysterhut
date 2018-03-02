/**   
 * @Title: TradeQuota.java 
 * @Package com.joinwe.pbap.entity.model 
 * @author zshen
 * @date 2015年9月28日 下午15:17:40 
 */
package com.memuli.oysterhutdb.bo;

import com.memuli.oysterhutcommon.BaseEntity;
import java.math.BigDecimal;

/**
 *交易限额配置
 */
public class TradeQuota extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/** 交易限额 ID **/
	private String quotaId;
	/** 交易代码 充值RC、投资IV、还款RP、放款LN、提现WD、收益IC、转账TF、冻结LK等等 **/
	private String trdCode;
	/** 最大限额 **/
	private BigDecimal amtCeiling;
	/** 最小限额 **/
	private BigDecimal amtFloor;
	/** 状态 0：无效  1：有效 **/
	private String status;
	
	public String getQuotaId() {
		return quotaId;
	}
	public void setQuotaId(String quotaId) {
		this.quotaId = quotaId;
	}
	public String getTrdCode() {
		return trdCode;
	}
	public void setTrdCode(String trdCode) {
		this.trdCode = trdCode;
	}
	public BigDecimal getAmtCeiling() {
		return amtCeiling;
	}
	public void setAmtCeiling(BigDecimal amtCeiling) {
		this.amtCeiling = amtCeiling;
	}
	public BigDecimal getAmtFloor() {
		return amtFloor;
	}
	public void setAmtFloor(BigDecimal amtFloor) {
		this.amtFloor = amtFloor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
