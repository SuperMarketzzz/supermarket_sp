package com.market.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.market.utils.CurrentUser;
import com.market.vo.UserInfo;
@Configuration
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().isAssignableFrom(UserInfo.class)
				&& parameter.hasParameterAnnotation(CurrentUser.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		//取出第二节中放入请求中的用户信息
		UserInfo user = (UserInfo)webRequest.getAttribute("currentUser", RequestAttributes.SCOPE_REQUEST);
		if(user != null) {
			return user;
		}
		
		throw new MissingServletRequestPartException("currentUser");
	}

}
