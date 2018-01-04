package com.jrl.p2p.demo.provider;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrl.p2p.demo.api.UserService;
import com.jrl.p2p.demo.api.model.Company;
import com.jrl.p2p.demo.api.model.CompanyCriteria;
import com.jrl.p2p.demo.api.model.User;
import com.jrl.p2p.demo.mapper.CompanyMapper;
import com.jrl.p2p.demo.mapper.UserMapper;

/**
 * UserService接口的实现类,提供用户相关服务
 * 
 * @author simon.lee
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	/**
	 * log for this class
	 */
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CompanyMapper companyMapper;

	/**
	 * 保存用户信息
	 */
	@Transactional
	public boolean saveUser(User user){
		boolean isSucc = false;
		try {
			logger.info("saveUser===>user:" + user.toString());
			Company c = user.getCompany();
			int cnt = companyMapper.saveCompany(c);
			if (cnt > 0) {
				CompanyCriteria cc = new CompanyCriteria();
				cc.setCompanyName(c.getCompanyName());
				Company dbCompany = companyMapper.getCompany(cc);
				c.setCompanyId(dbCompany.getCompanyId());
			}
			int cnt2 = userMapper.saveUser(user);
			isSucc = cnt > 0 && cnt2 > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSucc;
	}

	/**
	 * 获取用户信息
	 */
	public User getUser(String userId){
		logger.info("获取用户信息时的请求参数： userId=" + userId);
		User user = userMapper.getUser(userId);
		return user;
	}

	/**
	 * 获取用户列表信息
	 */
	public List<User> getUserList(){
		return userMapper.getUserList();
	}
}