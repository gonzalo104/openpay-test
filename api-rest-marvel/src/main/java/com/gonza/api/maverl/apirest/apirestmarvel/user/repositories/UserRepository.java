package com.gonza.api.maverl.apirest.apirestmarvel.user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonza.api.maverl.apirest.apirestmarvel.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
