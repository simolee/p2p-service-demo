package com.jrl.p2p.demo.api.model;

import java.io.Serializable;

public class CompanyCriteria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer companyId;
	
	/**
	 * 公司名称
	 */
	private String companyName;
	
	/**
	 * 公司地址
	 */
	private String companyAddress;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	
	
}
