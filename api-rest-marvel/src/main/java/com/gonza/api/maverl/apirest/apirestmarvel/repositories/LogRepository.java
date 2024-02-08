package com.gonza.api.maverl.apirest.apirestmarvel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gonza.api.maverl.apirest.apirestmarvel.entities.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
