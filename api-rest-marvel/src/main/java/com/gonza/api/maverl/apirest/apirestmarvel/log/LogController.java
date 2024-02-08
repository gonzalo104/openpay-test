package com.gonza.api.maverl.apirest.apirestmarvel.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonza.api.maverl.apirest.apirestmarvel.log.entities.Log;
import com.gonza.api.maverl.apirest.apirestmarvel.log.interfaces.LogService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/logs")
public class LogController {

  @Autowired
  private LogService logService;

  @GetMapping
  public List<Log> getMethodName() {
    return logService.findAll();
  }

}
