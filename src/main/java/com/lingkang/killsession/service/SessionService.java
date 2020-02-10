package com.lingkang.killsession.service;

import javax.servlet.http.HttpSession;

public interface SessionService {

  void delete(String sessionId);

  void create(HttpSession httpSession);
}
