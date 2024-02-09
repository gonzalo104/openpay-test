package com.gonza.api.maverl.apirest.apirestmarvel.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonza.api.maverl.apirest.apirestmarvel.user.model.User;
import com.gonza.api.maverl.apirest.apirestmarvel.user.service.IUserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping("/register")
  public  ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
    if (result.hasFieldErrors()) {
      return validation(result);
  }

    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
  }


  private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "The field " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

}
