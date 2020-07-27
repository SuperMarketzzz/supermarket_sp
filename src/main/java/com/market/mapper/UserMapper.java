package com.market.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.market.vo.User;

@Mapper
public interface UserMapper {
	public User getUserByName(@Param("name") String name);
}
