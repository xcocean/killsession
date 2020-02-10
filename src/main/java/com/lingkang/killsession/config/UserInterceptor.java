package com.lingkang.killsession.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component // 给spring托管
public class UserInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    if (request.getSession().getAttribute("username") == null) {
      response.sendRedirect("/login");//重定向到登录
      return false;
    }
    return true;
  }
}
