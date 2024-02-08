package com.gonza.api.maverl.apirest.apirestmarvel.log.interfaces;

import java.util.List;

import com.gonza.api.maverl.apirest.apirestmarvel.log.entities.Log;

public interface LogService {
  List<Log> findAll();
}
