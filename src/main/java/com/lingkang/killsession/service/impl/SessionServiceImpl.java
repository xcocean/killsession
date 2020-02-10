package com.lingkang.killsession.service.impl;

import com.lingkang.killsession.service.SessionService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

  //用于存储全部的session，key=sessionid
  private Map<String, HttpSession> sessionMap = new HashMap<>();

  public void create(HttpSession httpSession) {
    sessionMap.put(httpSession.getId(), httpSession);
  }

  public void delete(String sessionId) {
    try {
      //移除会话id
      sessionMap.get(sessionId).invalidate();
    } catch (Exception e) {
    }
  }
}