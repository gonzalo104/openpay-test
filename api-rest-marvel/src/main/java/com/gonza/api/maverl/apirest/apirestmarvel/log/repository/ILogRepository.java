package com.gonza.api.maverl.apirest.apirestmarvel.log.repository;

import org.springframework.stereotype.Repository;

import com.gonza.api.maverl.apirest.apirestmarvel.log.model.Log;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ILogRepository extends JpaRepository<Log, Long> {

}
