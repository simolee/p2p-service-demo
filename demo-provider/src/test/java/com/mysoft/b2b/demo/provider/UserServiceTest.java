package com.mysoft.b2b.demo.provider;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jrl.p2p.demo.api.UserService;
import com.jrl.p2p.demo.api.model.Company;
import com.jrl.p2p.demo.api.model.User;
import com.mysoft.b2b.demo.BaseTestCase;

/**
 * 用户测试用例
 * 
 * @author simon.lee
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest extends BaseTestCase {
	private static final Logger logger = Logger.getLogger(UserServiceTest.class);

	@Autowired
	private UserService userService;

	@Test
	public void testGetUserList() {
		List<User> userList = userService.getUserList();
		for (User user : userList) {
			logger.info("========>" + user.toString());
		}
	}

	//@Test
	public void testSaveUser() {
		logger.info("================testSaveUser()=======================");
		String userName = "testUser";
		String mobile = "138" + String.format("%08d", new Random().nextInt(100000000));
		String address = "address";
		String companyName = "companyName" + mobile;
		String companyAddress = "companyAddress";

		// 用户
		User user = new User();
		user.setUserName(userName);
		user.setMobile(mobile);
		user.setAddress(address);

		// 用户公司
		Company company = new Company();
		company.setCompanyName(companyName);
		company.setAddress(companyAddress);

		// 设置用户公司
		user.setCompany(company);

		logger.info("================" + user.toString());

		try {
			boolean isSucc = userService.saveUser(user);
			Assert.assertTrue(isSucc);
			logger.info("保存用户成功!");
		} catch (Exception ex) {
			Assert.assertTrue(false);
			logger.error("保存用户失败!", ex);
		}
	}
}
