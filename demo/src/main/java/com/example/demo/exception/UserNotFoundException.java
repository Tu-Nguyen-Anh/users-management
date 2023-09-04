package com.example.demo.exception;

import com.example.demo.exception.base.NotFoundException;

public class UserNotFoundException extends NotFoundException {
  public UserNotFoundException(String id) {
    super("User", id);
  }
  public UserNotFoundException(int id) {
    super("User", Integer.toString(id));
  }
}
