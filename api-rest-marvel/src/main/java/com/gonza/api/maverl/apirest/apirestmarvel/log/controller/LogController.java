package com.gonza.api.maverl.apirest.apirestmarvel.log.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonza.api.maverl.apirest.apirestmarvel.log.model.Log;
import com.gonza.api.maverl.apirest.apirestmarvel.log.service.ILogService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/logs")
public class LogController {

  @Autowired
  private ILogService logService;

  @GetMapping
  public List<Log> getMethodName() {
    return logService.findAll();
  }

}
