package com.example.demo.exception;

import com.example.demo.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class UserUpdateException extends BaseException {
  public UserUpdateException(String message) {
    super();
    setCode("com.example.demo.exception.UserUpdateException");
    setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    addParam("message", message);
  }
}