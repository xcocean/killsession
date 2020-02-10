package com.lingkang.killsession.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

  @Autowired
  private UserInterceptor userInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //添加拦截器，拦截所有路径
    registry.addInterceptor(userInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/login");//排除登录的路径
  }
}
