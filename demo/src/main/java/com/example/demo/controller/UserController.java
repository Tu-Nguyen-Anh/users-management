package com.example.demo.controller;

import com.example.demo.constant.MessageResponse;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.LoginResponse;
import com.example.demo.dto.response.ResponseGeneral;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
  private static final Logger log = LoggerFactory.getLogger(UserController.class);
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("")
  public ResponseGeneral<UserResponse> create(@RequestBody @Valid UserRequest userRequest) {
    log.info("(create) request: {}", userRequest);
    UserResponse userResponse = userService.create(userRequest);
    return ResponseGeneral.ofCreated(MessageResponse.CREATE_USER, userResponse);
  }

  @PutMapping("/{id}")
  public ResponseGeneral<UserResponse> update(
        @RequestBody @Valid UserRequest userRequest, @PathVariable(name = "id") int id) {
    log.info("(update) Request to update user with id {}: {}", id, userRequest);
    UserResponse user = userService.update(userRequest, id);
    return new ResponseGeneral<>(MessageResponse.UPDATE_SUCCESS, user, HttpStatus.OK.value());
  }

  @GetMapping("")
  public ResponseGeneral<List<UserResponse>> list() {
    log.info("(list) Request to get all users.");
    List<UserResponse> users = userService.list();
    return new ResponseGeneral<>(MessageResponse.GET_USER, users, HttpStatus.OK.value());
  }

  @DeleteMapping("/{id}")
  public ResponseGeneral<Void> delete(@PathVariable(name = "id") int id) {
    log.info("(delete) Request to delete user with id: {}", id);
    userService.delete(id);
    return new ResponseGeneral<>(MessageResponse.DELETE_USER, HttpStatus.OK.value());
  }

  @PostMapping("/login")
  public ResponseGeneral<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    LoginResponse user = userService.login(loginRequest);
    log.info("(login) User logged in successfully: {}", user.getUsername());
    return new ResponseGeneral<>(MessageResponse.LOGIN_SUCCESS, user, HttpStatus.OK.value());
  }
}
