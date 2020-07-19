package com.market.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.market.interctpor.LoginInterctpor;

@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter{
	//tag 为true 则为开启状态，为false 则为关闭状态
    private boolean tag=true;
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 配置某些路径不拦截
        if(tag==true) {
            InterceptorRegistration addInterceptor  = registry.addInterceptor(new LoginInterctpor());
            addInterceptor.excludePathPatterns("/test");
            addInterceptor.addPathPatterns("/**");
        }else {
             
        }
         
        //如果有多个拦截器
        //InterceptorRegistration addInterceptor2  = registry.addInterceptor(new MyInterceptor2());
         
        super.addInterceptors(registry);
    }
}
