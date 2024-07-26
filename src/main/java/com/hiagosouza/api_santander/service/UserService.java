package com.hiagosouza.api_santander.service;

import com.hiagosouza.api_santander.model.User;

public interface UserService {
  User findById(Long Id);

  User createUser(User userToCreate);
}
