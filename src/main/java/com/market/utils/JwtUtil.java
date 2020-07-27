package com.market.utils;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.market.vo.User;

/**
 * token生成的方法
 * @author Administrator
 *
 */
public class JwtUtil {
	public static String getToken(User user) {
		Date start = new Date();
		//一小时有效
		long currentTime = System.currentTimeMillis()+60*60*1000;
		Date end = new Date(currentTime);
		String token = "";
		token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(user.getPwd()));
		return token;	
	}
}
