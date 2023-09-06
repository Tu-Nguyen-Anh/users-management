package com.example.demo.exception.base;


import static com.example.demo.constant.Message.ExceptionStatusConstant.CONFLICT;

public class ConflictException extends BaseException {
  public ConflictException(String objectName) {
    setCode("com.ncsgroup.login.exception.base.ConflictException");
    setStatus(CONFLICT);
    addParam("objectName", objectName);
  }
}