package com.market.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.mapper.UserMapper;
import com.market.service.IUserService;
import com.market.vo.User;
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper UserMapper;
	
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String name) {
		return UserMapper.getUserByName(name);
	}

}
