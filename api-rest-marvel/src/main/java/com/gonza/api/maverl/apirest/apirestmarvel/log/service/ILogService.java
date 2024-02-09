package com.gonza.api.maverl.apirest.apirestmarvel.log.service;

import java.util.List;

import com.gonza.api.maverl.apirest.apirestmarvel.log.model.Log;

public interface ILogService {
  List<Log> findAll();
}
