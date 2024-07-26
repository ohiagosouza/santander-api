package com.hiagosouza.api_santander.controller;

import com.hiagosouza.api_santander.model.User;
import com.hiagosouza.api_santander.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable Long Id) {
    var user = userService.findById(Id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<User> create(@RequestBody User userToCreate) {
    var userCreated = userService.createUser(userToCreate);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userCreated.getId())
            .toUri();
    return ResponseEntity.created(location).body(userCreated);
  }
}
