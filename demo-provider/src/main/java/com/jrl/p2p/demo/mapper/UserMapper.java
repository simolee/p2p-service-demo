package com.jrl.p2p.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jrl.p2p.demo.api.model.User;

/**
 * 用户信息的Mapper
 * 
 * @author simon.lee
 * 
 */
@Component("userMapper")
public interface UserMapper {
	
	/**
	 * 保存用户信息
	 * 
	 * @param user
	 */
	int saveUser(User user);

	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	User getUser(String userId);

	/**
	 * 获取用户列表信息
	 * 
	 * @return
	 */
	List<User> getUserList();
}
