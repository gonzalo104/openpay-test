package com.gonza.api.maverl.apirest.apirestmarvel.interceptors;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.gonza.api.maverl.apirest.apirestmarvel.log.entities.Log;
import com.gonza.api.maverl.apirest.apirestmarvel.log.repositories.LogRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

  @Autowired
  private LogRepository logRepository;

  @SuppressWarnings("null")
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //return true;
    HandlerMethod method = (HandlerMethod) handler;
    logger.info("LogInterceptor: preHandler()... " + method.getMethod().getName());

    Log log = new Log();
    log.setEndpoint(request.getRequestURI());
    log.setDate(new Date());

    logRepository.save(log);

    return true;
  }
}
