package com.gonza.api.maverl.apirest.apirestmarvel.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonza.api.maverl.apirest.apirestmarvel.log.entities.Log;
import com.gonza.api.maverl.apirest.apirestmarvel.log.interfaces.LogService;
import com.gonza.api.maverl.apirest.apirestmarvel.log.repositories.LogRepository;

@Service
public class LogServiceImpl implements LogService {

  @Autowired
  private LogRepository logRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Log> findAll() {
    return logRepository.findAll();
  }

}
