package com.example.demo.exception.base;

import static com.example.demo.constant.Message.ExceptionStatusConstant.UNAUTHORIZED;

public class AuthenticationException extends BaseException {
  public AuthenticationException() {
    setCode("com.example.demo.exception.base.AuthenticationException");
    setStatus(UNAUTHORIZED);
  }
}
