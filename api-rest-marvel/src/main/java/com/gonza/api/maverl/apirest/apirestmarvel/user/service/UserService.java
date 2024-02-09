package com.gonza.api.maverl.apirest.apirestmarvel.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonza.api.maverl.apirest.apirestmarvel.user.model.User;
import com.gonza.api.maverl.apirest.apirestmarvel.user.repository.IUserRepository;

@Service
public class UserService implements IUserService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private IUserRepository userRepository;

  @Override
  @Transactional
  public User save(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(user);

  }

}
