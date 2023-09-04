package com.example.demo.exception;

import com.example.demo.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class DuplicateUsernameException extends BaseException {
  public DuplicateUsernameException(String username) {
    super();
    setCode("com.example.demo.exception.DuplicateUsernameException");
    setStatus(HttpStatus.CONFLICT.value());
    addParam("username", username);
  }
}