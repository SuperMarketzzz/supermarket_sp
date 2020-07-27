package com.market.service;

import com.market.vo.User;

public interface IUserService {
	public User getUserById(String id);
	public User getUserByName(String name);
}
