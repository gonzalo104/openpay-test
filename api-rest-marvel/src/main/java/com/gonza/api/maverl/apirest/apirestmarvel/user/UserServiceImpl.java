package com.gonza.api.maverl.apirest.apirestmarvel.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonza.api.maverl.apirest.apirestmarvel.user.entities.User;
import com.gonza.api.maverl.apirest.apirestmarvel.user.interfaces.UserService;
import com.gonza.api.maverl.apirest.apirestmarvel.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public User save(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(user);

  }

}
