package com.market.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.market.interctpor.LoginInterctpor;

@Configuration
public class MyWebConfig extends WebMvcConfigurationSupport{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterctpor()).addPathPatterns("/**");
	}
	
	@Bean
	public LoginInterctpor loginInterctpor() {
		return new LoginInterctpor();
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(new CurrentUserMethodArgumentResolver());
	}
}
