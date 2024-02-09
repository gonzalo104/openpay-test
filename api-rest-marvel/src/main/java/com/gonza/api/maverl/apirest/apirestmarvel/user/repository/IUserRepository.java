package com.gonza.api.maverl.apirest.apirestmarvel.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonza.api.maverl.apirest.apirestmarvel.user.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
