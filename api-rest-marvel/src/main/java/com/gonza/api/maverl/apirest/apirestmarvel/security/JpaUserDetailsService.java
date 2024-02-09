package com.gonza.api.maverl.apirest.apirestmarvel.security;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonza.api.maverl.apirest.apirestmarvel.user.model.User;
import com.gonza.api.maverl.apirest.apirestmarvel.user.repository.IUserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
  @Autowired
  private IUserRepository repository;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> userOptional = repository.findByUsername(username);

    if (userOptional.isEmpty()) {
        throw new UsernameNotFoundException(String.format("Username %s not found!", username));
    }

    User user = userOptional.orElseThrow();

    List<GrantedAuthority> authorities =  new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

    return new org.springframework.security.core.userdetails.User(
      user.getUsername(), 
        user.getPassword(), 
        user.isEnabled(),
        true,
        true,
        true,
        authorities
      );
  }

}
