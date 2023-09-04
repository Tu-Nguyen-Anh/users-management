package com.example.demo.exception;

import com.example.demo.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class UserCreationException extends BaseException {
  public UserCreationException(String message) {
    super();
    setCode("com.example.demo.exception.UserCreationException");
    setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    addParam("message", message);
  }
}