package com.memuli.oysterhutdb.dto;
/**
 * 
 * @author mario
 *
 */
public enum UserClientType {
	PC("");

	private String key;
	private UserClientType(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
}
