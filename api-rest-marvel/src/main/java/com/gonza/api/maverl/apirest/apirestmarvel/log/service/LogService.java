package com.gonza.api.maverl.apirest.apirestmarvel.log.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonza.api.maverl.apirest.apirestmarvel.log.model.Log;
import com.gonza.api.maverl.apirest.apirestmarvel.log.repository.ILogRepository;

@Service
public class LogService implements ILogService {

  @Autowired
  private ILogRepository logRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Log> findAll() {
    return logRepository.findAll();
  }

}
