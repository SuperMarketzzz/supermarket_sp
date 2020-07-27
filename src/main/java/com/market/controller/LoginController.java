package com.market.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.market.service.IUserService;
import com.market.utils.JwtUtil;
import com.market.utils.PassToken;
import com.market.vo.ResponseEntity;
import com.market.vo.User;

@RestController
@RequestMapping("login")
public class LoginController {
	@Autowired
	private IUserService userServiceImpl;
	
	@PassToken
    @RequestMapping(value = "/loginByName",method = RequestMethod.POST)
    public ResponseEntity login(HttpServletRequest request,@RequestBody User user){
        User loginUser=userServiceImpl.getUserByName(user.getName());
        if(loginUser == null) {
        	return ResponseEntity.fail("登录失败，用户不存在");
        }else if(!user.getPwd().equals(loginUser.getPwd())) {
        	return ResponseEntity.fail("登录失败，密码错误");
        }else {
        	String token = JwtUtil.getToken(loginUser);
        	return ResponseEntity.ok(token);
        }
        
	}
}
