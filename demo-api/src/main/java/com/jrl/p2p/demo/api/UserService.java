package com.jrl.p2p.demo.api;

import java.util.List;

import com.jrl.p2p.demo.api.model.User;

/**
 * 用户服务接口,提供用户相关服务
 * 
 * @author simon.lee
 * 
 */
public interface UserService {
	/**
	 * 保存用户信息
	 * 
	 * @param user
	 * @return
	 * @throws UserServiceException
	 */
	boolean saveUser(User user);

	/**
	 * 通过用户ID查找用户的详细信息
	 * 
	 * @param userId
	 * @return
	 * @throws UserServiceException
	 */
	User getUser(String userId);

	/**
	 * 获取用户列表数据
	 * 
	 * @return
	 * @throws UserServiceException
	 */
	List<User> getUserList();
}