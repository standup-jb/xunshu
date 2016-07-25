package com.xunshu.service;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.xunshu.dao.UserMapper;
import com.xunshu.model.User;

@Service
public class UserService {

	@Resource
	private UserMapper userMapper;
	
	public User findUserByName(String username)
	{
		return userMapper.findUserByName(username);
	}
	
	
	public User findUserByEmail(String email)
	{
		return userMapper.findUserByEmail(email);
	}
	public void add(User user) {
		userMapper.addUser(user);  
	}
	
}
