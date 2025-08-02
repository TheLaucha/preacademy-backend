package com.coworking.coworking.service;

import com.coworking.coworking.model.User;
import com.coworking.coworking.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
  private final UserRepo userRepo;


  @Override
  public User saveUser(User user) {
    return userRepo.save(user);
  }

  @Override
  public List<User> findAll() {
    return userRepo.findAll();
  }

  @Override
  public Optional<User> findById(Long id) {
    return userRepo.findById(id);
  }
}
