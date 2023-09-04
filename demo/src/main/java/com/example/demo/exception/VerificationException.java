package com.example.demo.exception;

import com.example.demo.exception.base.AuthenticationException;
import org.springframework.http.HttpStatus;

public class VerificationException extends AuthenticationException {
  public VerificationException() {
    super();
    setCode("com.example.demo.exception.AuthenticationException");
    setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
  }
}