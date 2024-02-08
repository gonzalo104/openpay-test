package com.gonza.api.maverl.apirest.apirestmarvel.log.repositories;

import org.springframework.stereotype.Repository;

import com.gonza.api.maverl.apirest.apirestmarvel.log.entities.Log;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
