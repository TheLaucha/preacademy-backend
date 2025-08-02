package com.coworking.coworking.controller;

import com.coworking.coworking.dto.UserRequestDTO;
import com.coworking.coworking.model.Role;
import com.coworking.coworking.model.User;
import com.coworking.coworking.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getAll(){
    List<User> users = userService.findAll();

    return ResponseEntity.ok(users);
  }

  // ?? Tengo dudas sobre lo retornado, si esta bien o como es la mejor forma de hacerlo.
  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) throws UserPrincipalNotFoundException {
    return userService.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User no encontrado"));
  }

  @PostMapping
  public ResponseEntity<User> createUser(@Valid @RequestBody UserRequestDTO dto){
    User user = new User();
    user.setFullName(dto.getFullName());
    user.setEmail(dto.getEmail());
    user.setRole(Role.USER);

    User savedUser = userService.saveUser(user);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
  }
}
