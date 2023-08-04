package com.example.demo.exception;

import com.example.demo.constant.MessageResponse;

public class NotFoundException extends BaseException {
  public NotFoundException() {
    super();
    setCode(404);
    setMessage(MessageResponse.USER_NOT_FOUND);
  }
}