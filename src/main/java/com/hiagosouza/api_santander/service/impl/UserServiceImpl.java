package com.hiagosouza.api_santander.service.impl;

import com.hiagosouza.api_santander.model.User;
import com.hiagosouza.api_santander.repository.UserRepository;
import com.hiagosouza.api_santander.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;
  };


  @Override
  public User findById(Long Id) {
    return userRepository.findById(Id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public User createUser(User userToCreate) {
    if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
      throw new IllegalArgumentException("This user already exists");
    }
    return userRepository.save(userToCreate);
  }
}
