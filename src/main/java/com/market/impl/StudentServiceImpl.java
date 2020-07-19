package com.market.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.mapper.StudentMapper;
import com.market.service.IStudentService;
import com.market.vo.ResponseEntity;
import com.market.vo.StudentVo;
@Service("studentServiceImpl")
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public ResponseEntity getStuList() {
		List<StudentVo> stuList = new ArrayList<StudentVo>();
		
		try {
			stuList = studentMapper.getStuList();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.fail("查询失败");
		}
		
		return ResponseEntity.ok(stuList);
	}

}
