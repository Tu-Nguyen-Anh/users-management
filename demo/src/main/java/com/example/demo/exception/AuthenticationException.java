package com.example.demo.exception;

import com.example.demo.constant.MessageResponse;

public class AuthenticationException extends BaseException {
  public AuthenticationException() {
    super();
    setCode(500);
    setMessage(MessageResponse.INVALID);
  }
}
