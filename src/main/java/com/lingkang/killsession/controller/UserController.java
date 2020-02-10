package com.lingkang.killsession.controller;

import com.lingkang.killsession.service.SessionService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  @Autowired
  private HttpServletRequest request;
  @Autowired
  private SessionService sessionService;

  private static Map<String, String> sessionId = new HashMap<>();

  @GetMapping(value = {"/", "index"})
  public String index() {
    return "index";
  }

  @GetMapping("login")
  public String toLogin() {
    return "login";
  }

  @GetMapping("logout")
  public String logout(HttpServletResponse response) {
    request.getSession().removeAttribute("username");
    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
      if (c.getName().equals("JSESSIONID")) {
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        break;
      }
    }
    return "login";
  }

  @PostMapping("login")
  public String login() {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username.equals("123") && password.equals("123")) {
      //登录成功！
      //实现只能一个用户登录
      //删除上一个session的username
      if (sessionId.get(username) != null) {
        sessionService.delete(sessionId.get(username));
      }
      //记录下每次登陆的sessionId，其中key为username，可根据实际情况定义
      sessionId.put(username, request.getSession().getId());
      request.getSession().setAttribute("username", "123");
      return "redirect:/index"; //使用重定向，
    }
    return "login";
  }
}
