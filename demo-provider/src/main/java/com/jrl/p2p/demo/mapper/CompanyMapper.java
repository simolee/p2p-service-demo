package com.jrl.p2p.demo.mapper;

import org.springframework.stereotype.Component;

import com.jrl.p2p.demo.api.model.Company;
import com.jrl.p2p.demo.api.model.CompanyCriteria;

/**
 * 公司信息Mapper
 * 
 * @author simon.lee
 * 
 */
@Component("companyMapper")
public interface CompanyMapper {
	/**
	 * 保存公司信息
	 * 
	 * @param company
	 */
	int saveCompany(Company company);
	
	/**
	 * 获取公司信息
	 * 
	 * @param cc
	 * @return
	 */
	Company getCompany(CompanyCriteria cc);
}
