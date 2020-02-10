package com.lingkang.killsession.config;

import com.lingkang.killsession.service.SessionService;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  session 监听事件
 */
@WebListener
public class SessionListenerConfig implements HttpSessionListener {

  @Autowired
  private SessionService sessionService;

  /* Session创建事件 */
  @Override
  public void sessionCreated(HttpSessionEvent event) {
    sessionService.create(event.getSession());
  }

}
