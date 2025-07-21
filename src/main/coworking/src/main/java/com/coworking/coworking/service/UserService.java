package com.coworking.coworking.service;

import com.coworking.coworking.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
  User saveUser(User user);
  List<User> findAll();
  Optional<User> findById(Long id);
}
