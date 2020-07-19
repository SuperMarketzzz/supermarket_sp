package com.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.vo.StudentVo;
@Mapper
public interface StudentMapper {
	public List<StudentVo> getStuList();
}
